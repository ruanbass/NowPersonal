package br.com.ufpb.nowpersonal.activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import br.com.ufpb.nowpersonal.R;

/* Tela de boas vindas da aplicação
 * É aqui onde será carregado dados futuros do aplicativo
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        hideNavigationBar(); // Oculta a barra de navegação e status

        // Captura de componentes da interface
        View mCircleView = findViewById(R.id.circle_splash);
        View mWeightView = findViewById(R.id.weight_splash);
        View mAppNameView = findViewById(R.id.app_name);

        final int DURATION = 1000; // Define o tempo da animação - em milissegundos
        YoYo.with(Techniques.RollIn).duration(DURATION).playOn(mCircleView); // Aplico a animação em casa view
        YoYo.with(Techniques.RollIn).duration(DURATION).playOn(mWeightView);

        YoYo.with(Techniques.RollIn).duration(DURATION).playOn(mAppNameView);

        new SplashAsyncTask().execute((Void) null); // Executo a Thread para a chamada para outra tela

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void hideNavigationBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    /* Esta classe é para carregar componentes ou dados em segundo plano
     * esta classe será necessária no futuro, quando utilizar um banco de dados remoto
     */
    private class SplashAsyncTask extends AsyncTask<Void, Void, Boolean>{

        private final int TIME = 2000;

        @Override
        protected Boolean doInBackground(Void... voids) {
            // Toda a lógica para carregar dados em segundo plano
            // deverá ser feita neste método
            try{
                Thread.sleep(TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            // Neste método é onde você fará a ação após a conclusão
            // do carregamento de dados

            if(aBoolean){
                Intent intent = new Intent(SplashActivity.this, SlideActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}
