package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.UserModel;
import apap.tutorial.haidokter.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public UserModel findByUsername(String username) {
        return userDb.findByUsername(username);
    }

    @Override
    public Boolean checkValidOldPassword(UserModel user, String oldPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String oldpass = encrypt(oldPassword);
        String pass = passwordEncoder.encode(user.getPassword());
        if (passwordEncoder.matches(oldpass, pass)) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Boolean checkValidConfirmation(String newPassword, String passConfirm) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String newpass = encrypt(newPassword);
        String confirmpass = encrypt(passConfirm);
        if (passwordEncoder.matches(newpass, confirmpass)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public UserModel changePassword(UserModel user, String newPassword) {
        String newpass = encrypt(newPassword);
        user.setPassword(newpass);
        return userDb.save(user);
    }
}
