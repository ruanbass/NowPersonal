package br.com.ufpb.nowpersonal.acitivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import br.com.ufpb.nowpersonal.R;

public class BuscaActivity extends AppCompatActivity {


     public List<Personal> personals;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca);
    }
}
