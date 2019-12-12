package asm.asmtunis.com.feedback;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    int currentPosition=0;
    ConstraintLayout main_frame;
    ImageView cry_face,sad_face,ok_face,happy_face,very_happy_face;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekBar_luminosite);
        main_frame = (ConstraintLayout) findViewById(R.id.main_frame);
        cry_face = (ImageView) findViewById(R.id.cry_face);
        sad_face = (ImageView) findViewById(R.id.sad_face);
        ok_face = (ImageView) findViewById(R.id.ok_face);
        happy_face = (ImageView) findViewById(R.id.happy_face);
        very_happy_face = (ImageView) findViewById(R.id.very_happy_face);


        initValues();


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, final int progress, final boolean fromUser) {
                changeBackgroundColor(progress);

                changeFaceImage(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
               // updateProgress(progress);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
               updateProgress(seekBar.getProgress());
            }
        });
    }

    private void changeFaceImage(int progress) {
        if (progress >= 0 && progress <= 25){
            int p= (int) ((progress)*10.2);
            Log.d("value", "changeFaceImage: "+p);
            cry_face.setAlpha((int) (255-((progress)*10.2)));
            sad_face.setAlpha((int) ((progress)*10.2));
           ok_face.setVisibility(View.GONE);
            happy_face.setVisibility(View.GONE);
            very_happy_face.setVisibility(View.GONE);
            cry_face.setVisibility(View.VISIBLE);
            sad_face.setVisibility(View.VISIBLE);
        }
        else if (progress > 25 && progress <= 50){
            int p= (int) ((progress-25)*10.2);
            Log.d("value2", "changeFaceImage: "+p);
            sad_face.setAlpha((int) (255-((progress-25)*10.2)));
            ok_face.setAlpha((int) ((progress-25)*10.2));
            ok_face.setVisibility(View.VISIBLE);
            happy_face.setVisibility(View.GONE);
            very_happy_face.setVisibility(View.GONE);
            cry_face.setVisibility(View.GONE);
            sad_face.setVisibility(View.VISIBLE);
        }
        else if (progress > 50 && progress <= 75){
            ok_face.setAlpha((int) (255-((progress-50)*10.2)));
            happy_face.setAlpha((int) ((progress-50)*10.2));
            ok_face.setVisibility(View.VISIBLE);
            happy_face.setVisibility(View.VISIBLE);
            very_happy_face.setVisibility(View.GONE);
            cry_face.setVisibility(View.GONE);
            sad_face.setVisibility(View.GONE);
        }
        else if (progress > 75 && progress <= 100){
            happy_face.setAlpha((int) (255-((progress-75)*10.2)));
            very_happy_face.setAlpha((int) ((progress-75)*10.2));
            ok_face.setVisibility(View.GONE);
            happy_face.setVisibility(View.VISIBLE);
            very_happy_face.setVisibility(View.VISIBLE);
            cry_face.setVisibility(View.GONE);
            sad_face.setVisibility(View.GONE);
        }



    }

    private void changeBackgroundColor(int progress) {
        float[] hsvColor = {0, 1, 200};
        hsvColor[0] = 100f * progress /150;
        hsvColor[0]+=30;
        main_frame.setBackgroundColor(Color.HSVToColor(hsvColor));
    }

    private void initValues() {
        seekBar.setProgress(50);
        cry_face.setAlpha(0);
        sad_face.setAlpha(0);
        ok_face.setAlpha(250);
        happy_face.setAlpha(0);
        very_happy_face.setAlpha(0);
    }

    private void updateProgress(int progress) {
        if (progress > 0 && progress <= 13)
            ObjectAnimator.ofInt(seekBar, "progress", 0).setDuration(100).start();
        else if (progress > 13 && progress <= 37)
            ObjectAnimator.ofInt(seekBar, "progress", 25).setDuration(100).start();
       else if (progress > 37 && progress <= 63)
            ObjectAnimator.ofInt(seekBar, "progress", 50).setDuration(100).start();
        else if (progress > 63 && progress <= 87)
            ObjectAnimator.ofInt(seekBar, "progress", 75).setDuration(100).start();
       else if (progress > 87 && progress <= 100)
            ObjectAnimator.ofInt(seekBar, "progress", 100).setDuration(100).start();
    }

}
