package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.UserModel;
import apap.tutorial.haidokter.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;

    //asumsi huruf yang ada di dalam password adalah minimal mengandung 1 huruf kapital
    private static final String passwordRequirement = "^(?=.*[0-9])(?=.*[A-Z]).{8,}$";

    private static final Pattern patternPassword = Pattern.compile(passwordRequirement);

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
    public Boolean checkMatchPasswordWithPattern(String password) {
        Matcher match = patternPassword.matcher(password);
        if (match.find()) {
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

    @Override
    public Boolean checkValidate(UserModel user, UserModel userdb) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String uname = passwordEncoder.encode(user.getUsername());
        String pass = passwordEncoder.encode(user.getPassword());
        if (passwordEncoder.matches(uname, userdb.getUsername())) {
            if (passwordEncoder.matches(pass, userdb.getPassword())) {
                return true;
            }
            return false;
        }
        else {
            return false;
        }
    }
}
