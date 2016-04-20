package br.com.ufpb.nowpersonal.acitivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.ufpb.nowpersonal.R;

public class PerfilActivity extends AppCompatActivity {


    private Button mcadastroAluno;
    private Button cadastroPersonal;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        // o cadastro de usuario e de personal  ia reusar o codigo de telas por isso q so fiz 1
        mcadastroAluno = (Button) findViewById(R.id.cadastroAluno);
        mcadastroAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilActivity.this, CadastroActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //cadastroAluno = (Button) findViewById(R.id.cadastroAluno);
        //cadastroAluno.setOnClickListener(new View.OnClickListener() {

           // public void onClick(View v) {
               // Intent intent = new Intent(PerfilActivity.this, CadastroActivity.class);
              //  startActivity(intent);
             //   finish();

           // }

       // }//);

    }
}