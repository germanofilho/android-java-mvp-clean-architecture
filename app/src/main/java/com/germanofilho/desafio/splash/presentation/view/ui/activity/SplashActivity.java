package com.germanofilho.desafio.splash.presentation.view.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.germanofilho.desafio.R;
import com.germanofilho.desafio.core.util.Animation;
import com.germanofilho.desafio.main.presentation.view.ui.activity.MainActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Completable.complete()
                .delay(2, TimeUnit.SECONDS)
                .doOnComplete(this::goToMainActivity)
                .subscribe();

        Animation.fadeInSlow(findViewById(R.id.img_logo));
    }


    private void goToMainActivity(){
        startActivity(new Intent(this, MainActivity.class));
        finishAffinity();
    }
}
