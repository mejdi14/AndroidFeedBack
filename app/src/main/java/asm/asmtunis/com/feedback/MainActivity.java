package asm.asmtunis.com.feedback;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    int currentPosition=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekBar_luminosite);


        seekBar.setProgress(0);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, final int progress, final boolean fromUser) {
               currentPosition=progress;
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                       // if (fromUser){
                           // if (progress==currentPosition)
                         //   updateProgress(progress);
                     //   }
                    }
                };
                new Handler().postDelayed(r, 600);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
               // updateProgress(progress);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                ObjectAnimator.ofInt(seekBar, "progress", 0).setDuration(100).start();
            }
        });
    }

    private void updateProgress(int progress) {
        if (progress > 0 && progress < 10)
            seekBar.setProgress(0);
        else if (progress > 10 && progress < 30)
            seekBar.setProgress(20);
       else if (progress > 30 && progress < 50)
            seekBar.setProgress(40);
        else if (progress > 50 && progress < 70)
            seekBar.setProgress(60);
       else if (progress > 70 && progress < 90)
            seekBar.setProgress(80);
       else if (progress > 90 && progress < 100)
            seekBar.setProgress(100);

    }
}
