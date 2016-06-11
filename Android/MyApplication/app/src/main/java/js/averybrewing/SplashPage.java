package js.averybrewing;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashPage extends AppCompatActivity {


    private static boolean splashLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_page);
        if (!splashLoaded) {
            setContentView(R.layout.activity_splash_page);
            int secondsDelayed = 1;

            new Handler().postDelayed(new Runnable() {
                public void run() {
                    startActivity(new Intent(SplashPage.this, MainActivity.class));
                    finish();
                }
            }, secondsDelayed * 1500);

            splashLoaded = true;
        }
        else {
            Intent goToMainActivity = new Intent(SplashPage.this, MainActivity.class);
            goToMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(goToMainActivity);
            finish();
        }
    }
}
