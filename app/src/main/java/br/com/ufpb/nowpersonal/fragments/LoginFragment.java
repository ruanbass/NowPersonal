package br.com.ufpb.nowpersonal.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.com.ufpb.nowpersonal.R;

public class LoginFragment extends Fragment {

    private Button mLoginButton;
    private Button mRememberPassword;

    private EditText mMail;
    private EditText mPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        mLoginButton = (Button) view.findViewById(R.id.btn_login);
        mRememberPassword = (Button) view.findViewById(R.id.btn_remember_pasword);

        ((TextInputLayout) view.findViewById(R.id.layout_mail_login)).setTypeface(getTypeface());
        ((TextInputLayout) view.findViewById(R.id.layout_password_login)).setTypeface(getTypeface());

        mMail = (EditText) view.findViewById(R.id.login_mail);
        mMail.setTypeface(getTypeface());

        mPassword = (EditText) view.findViewById(R.id.login_password);
        mPassword.setTypeface(getTypeface());
        return view;
    }

    private Typeface getTypeface(){
        return Typeface.createFromAsset(getActivity().getAssets(), "fonts/roboto_regular.ttf");
    }


}
