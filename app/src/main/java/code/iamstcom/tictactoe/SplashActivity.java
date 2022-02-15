package code.iamstcom.tictactoe;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        TextView textView = findViewById(R.id.textView3);
        TextView textView2 = findViewById(R.id.textView2);
            textView.setAlpha(0f);
            textView2.setAlpha(0f);


        textView.animate()
                .translationY(textView.getHeight())
                .alpha(1f)
                .setStartDelay(1000)
                .setDuration(1200);

        textView2.animate()
                .translationY(textView.getHeight())
                .alpha(1f)
                .setStartDelay(1500)
                .setDuration(1000);

        ImageView imageView = findViewById(R.id.imageView3);
        imageView.setAlpha(0f);
        imageView.animate()
                .translationY(textView.getHeight())
                .alpha(1f)
                .setDuration(800);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, SceneActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
            }
        }, 4000);

    }
}
