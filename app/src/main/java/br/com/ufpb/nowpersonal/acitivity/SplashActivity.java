package br.com.ufpb.nowpersonal.acitivity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.ufpb.nowpersonal.R;

public class SplashActivity extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final int TIME = 2000;

        new Handler().postDelayed(this, TIME);
    }

    @Override
    public void run() {
        // Código da tela splash
        // Pré carregamento de dados
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
