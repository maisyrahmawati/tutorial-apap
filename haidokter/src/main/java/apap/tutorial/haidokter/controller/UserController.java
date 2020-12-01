package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.UserModel;
import apap.tutorial.haidokter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user, @ModelAttribute UserModel userdb) {
        if (!userService.checkMatchPasswordWithPattern(user.getPassword())){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid Password, please include at least 8 characters, 1 number, and 1 uppercase!"
            );
        }
        if (!userService.checkValidate(user, userdb)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "User is existing!"
            );
        }
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping({"/user/update-password/{username}", "/user/update-password"})
    private String updatePasswordFormPage(
            @PathVariable(required = false) String username,
            Model model
    ) {
        UserModel user = userService.findByUsername(username);
        model.addAttribute("user", user);

        return "form-update-password";
    }

    @PostMapping("/user/update-password")
    public String updatePasswordSubmit(
            @RequestParam("username") String username,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword,
            @RequestParam("passConfirm") String passConfirm,
            Model model
    ) {
        UserModel user = userService.findByUsername(username);
        if (!userService.checkValidOldPassword(user, oldPassword)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid Old Password!"
            );
        }
        if (!userService.checkMatchPasswordWithPattern(user.getPassword())){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid Password, please include at least 8 characters, 1 number, and 1 uppercase!"
            );
        }
        if (!userService.checkValidConfirmation(newPassword, passConfirm)){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid Confirmation Password!"
            );
        }
        UserModel userUpdate = userService.changePassword(user, newPassword);
        model.addAttribute("userUpdate", userUpdate);
        return "form-update-password-success";
    }
}
