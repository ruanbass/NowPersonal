package br.com.ufpb.nowpersonal.acitivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLException;

import br.com.ufpb.nowpersonal.R;
import br.com.ufpb.nowpersonal.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    private UserLoginTask mAuthTask = null;

    private EditText mUserName;
    private EditText mPassword;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        activateToolbar();

        mUserName = (EditText) findViewById(R.id.usuario);

        mPassword = (EditText) findViewById(R.id.senha);
        mPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int id, KeyEvent event) {
                if(id == R.id.login || id == EditorInfo.IME_NULL){
                    attemptLogin();
                    return true;
                }

                return false;
            }
        });

        (findViewById(R.id.btn_entrar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });

        (findViewById(R.id.btn_cadastrar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para tela de cadastro
                Intent intent = new Intent(LoginActivity.this, PerfilActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void activateToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_login);
        setSupportActionBar(toolbar);
    }

    /**
     * As tentativas de login ou registrar uma nova conta é especificado pelo formulário de login.
     * Se houver erros de formulário (e-mail inválido, campos em falta, etc.), os
     * erros são apresentados e não é feita nenhuma tentativa de login real.
     */
    public void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reseta os erros.
        mUserName.setError(null);
        mPassword.setError(null);

        // Captura os valores nos campos
        String email = mUserName.getText().toString();
        String password = mPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Verifica se a senha é válida, e se o usuário efetuou login com sucesso.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPassword.setError(getString(R.string.error_invalid_password));
            focusView = mPassword;
            cancel = true;
        }

        // Verifica se o e-mail é válido.
        if (TextUtils.isEmpty(email)) {
            mUserName.setError(getString(R.string.error_field_required));
            focusView = mUserName;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mUserName.setError(getString(R.string.error_invalid_email));
            focusView = mUserName;
            cancel = true;
        }

        if (cancel) {
            // se houver um erro, o erro é indicado no primeiro campo
            // de texto.
            focusView.requestFocus();
        } else {
            // Lança uma tentantiva de login em segundo plano
            showProgress(true);
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isEmailValid(String email) {
        return email.toLowerCase().contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 4 && password.length() <= 16;
    }

    /**
     * Exibe o progresso de login.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void showProgress(final boolean show) {
        if (show) {
            getSupportActionBar().hide();
        } else {
            getSupportActionBar().show();
        }
        // No Honeycomb MR2 temos as APIs ViewPropertyAnimator,
        // que permitem animações de forma fácil. Se estiver disponível,
        // usar essas APIs para fade-in e exibir a barra de progresso.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // Se as APIs ViewPropertyAnimator não estiverem disponíveis,
            // então simplesmente mostrar e ocultar os componentes de interface do usuário relevantes.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    /**
     * Representa uma tarefa login / registo assíncrona usadas para autenticar o usuário.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mSenha;
        private Usuario user;
        private boolean userExist;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mSenha = password;
            userExist = false;
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            try {
                Thread.sleep(1000);
                // Recuperar o usuário aqui
            } catch (InterruptedException e) {
                return false;
            }

            if(user != null){
                userExist = true;
                return user.getPassword().equalsIgnoreCase(mSenha);
            }

            return userExist;

        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;

            if (success) {
                // Caso o login e senha estejam corretos, o que fazer? Pra onde ir?
            } else {
                if (!userExist) {
                    mUserName.setError(getString(R.string.no_register_email));
                    mUserName.requestFocus();
                } else {
                    mPassword.setError(getString(R.string.error_incorrect_password));
                    mPassword.requestFocus();
                }
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}
