package rayagruops.com.demo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Animation anim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        anim.reset();
        TextView iv = (TextView) findViewById(R.id.textView2);
        iv.clearAnimation();
        iv.startAnimation(anim);




        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent myIntent = new Intent(Splash.this,
                        MainActivity.class);

                startActivity(myIntent);

                finish();







            }
        },3000);




    }


}
