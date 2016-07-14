package com.aftarobot.library.signin;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.aftarobot.library.R;
import com.aftarobot.library.data.UserDTO;
import com.aftarobot.library.util.SharedUtil;

/**
 * A placeholder fragment containing a simple view.
 */
public class SignInFragment extends Fragment implements SignInContract.View {

    public SignInFragment() {
    }

    int userType;
    EditText email, password;
    Button btnSend;
    SignInContract.Presenter presenter;
    View mView;
    SignInListener listener;
    Snackbar snackbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_sign_in, container, false);
        setFields();

        return mView;
    }
    public void setListener(SignInListener listener) {
        this.listener = listener;
        presenter = new SignInPresenter(this);
        if (presenter.checkSignInStatus()) {
            Log.i(TAG, "setListener: user is signed in already");
            listener.onSignedIn();
        }
    }
    @Override
    public void sendSignIn() {
        if (getEmail().isEmpty()) {
            email.setError("Please enter email");
            return;
        }
        if (getPassword().isEmpty()) {
            email.setError("Please enter password");
            return;
        }
        hideKeyboard();
        presenter.signIn(getEmail(),getPassword());
    }

    private void setFields() {
        email = (EditText)mView.findViewById(R.id.email);
        password = (EditText)mView.findViewById(R.id.password);
        btnSend = (Button) mView.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSignIn();
            }
        });
    }
    void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(email.getWindowToken(), 0);
    }

    @Override
    public String getEmail() {

        return email.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void setUserType(int userType) {
        this.userType = userType;
    }


    @Override
    public void emailError() {

    }

    @Override
    public void passwordError() {

    }

    @Override
    public void onSignInClicked() {

    }

    @Override
    public void onForgotClicked() {

    }

    @Override
    public void onLoginFailed() {
        Log.e(TAG, "------------- onLoginFailed: ");
        snackbar = Snackbar.make(email,"Sign in failed. Please check your email and password", Snackbar.LENGTH_INDEFINITE);
        snackbar.setActionTextColor(ContextCompat.getColor(getContext(),R.color.red_500));
        snackbar.setAction("Close", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }

    @Override
    public void onLoginSucceeded(UserDTO user) {
        Log.i(TAG, "onLoginSucceeded: user: " + user.getName());
        SharedUtil.saveUser(user, getContext());
        listener.onSignedIn();
    }
    public interface SignInListener {
        void onSignedIn();
    }


    public static final String TAG = SignInFragment.class.getSimpleName();
}
