package com.aftarobot.library.signin;

import android.util.Log;

import com.aftarobot.library.data.UserDTO;
import com.aftarobot.library.util.DataAPI;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by aubreymalabie on 7/11/16.
 */

public class SignInPresenter implements SignInContract.Presenter {

    static final String TAG = SignInPresenter.class.getSimpleName();
    SignInContract.View view;
    DataAPI api;
    FirebaseAuth firebaseAuth;

    public SignInPresenter(SignInContract.View view) {
        this.view = view;
        api = new DataAPI();
        firebaseAuth = FirebaseAuth.getInstance();

    }
    @Override
    public boolean checkSignInStatus() {
        Log.d(TAG, "checkSignInStatus: ");
        boolean signedIn = false;
        if (firebaseAuth.getCurrentUser() != null) {
            signedIn = true;
        } else {
            signedIn = false;
        }
        return signedIn;
    }

    @Override
    public void signIn(String email, String password) {
        Log.w(TAG, "signIn: " + email);
        api.signIn(email, password, new DataAPI.OnSignedIn() {
            @Override
            public void onResponse(UserDTO user) {
                view.onLoginSucceeded(user);
            }

            @Override
            public void onError() {
                view.onLoginFailed();
            }
        });
    }


}
