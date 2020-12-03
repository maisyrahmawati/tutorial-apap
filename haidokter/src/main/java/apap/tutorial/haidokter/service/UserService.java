package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);

    public String encrypt(String password);

    UserModel findByUsername(String username);

    Boolean checkValidOldPassword(UserModel user, String oldPassword);

    Boolean checkValidConfirmation(String newPassword, String passConfirm);

    Boolean checkMatchPasswordWithPattern(String password);

    UserModel changePassword(UserModel user, String newPassword);
}
