package asm.asmtunis.com.feedback;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.xw.repo.BubbleSeekBar;

public class MainActivity extends AppCompatActivity {
    BubbleSeekBar seekbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar_luminosite);
        seekbar = (BubbleSeekBar)findViewById(R.id.seekbar);

       seekbar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
           @Override
           public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
               Log.d("value", "onProgressChanged: "+progress);
           }

           @Override
           public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {

           }

           @Override
           public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

           }
       });

        seekBar.setProgress(0);
        seekBar.incrementProgressBy(50);
        seekBar.setMax(200);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = progress / 10;
                progress = progress * 10;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
