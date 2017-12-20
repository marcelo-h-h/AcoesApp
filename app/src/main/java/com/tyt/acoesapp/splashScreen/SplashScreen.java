package com.tyt.acoesapp.splashScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tyt.acoesapp.R;
import com.tyt.acoesapp.telaInicial.MainActivity;

public class SplashScreen extends AppCompatActivity {
    //Exibe a splashScreen por 2 segundos, depois inicia a main e termina esta action
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Pause the app execution for 2 seconds
        Thread timer= new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    openMain();
                }
            }
        };
        timer.start();
    }

    protected void openMain(){
        Intent intentMain = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intentMain);
        finish(); //When MainActivity is opened, this activity becomes useless, no point to return to it
    }
}
