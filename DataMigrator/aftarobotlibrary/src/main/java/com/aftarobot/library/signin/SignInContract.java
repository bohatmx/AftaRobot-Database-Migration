package com.aftarobot.library.signin;

import com.aftarobot.library.data.UserDTO;

/**
 * Created by aubreymalabie on 7/11/16.
 */

public class SignInContract {

    public static final int ADMIN = 1, OWNER = 2, MARSHAL = 3, DRIVER = 4, PATROLLER = 5, COMMUTER = 6;

    public interface View {
        String getEmail();
        String getPassword();
        void sendSignIn();
        void setUserType(int userType);
        void emailError();
        void passwordError();
        void onSignInClicked();
        void onForgotClicked();
        void onLoginFailed();
        void onLoginSucceeded(UserDTO user);
    }

    public interface Presenter {
        boolean checkSignInStatus();
        void signIn(String email, String password);
    }

}
