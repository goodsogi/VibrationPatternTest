package com.seriouscompany.helloworld;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Vibrator mVibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vibration_test);

        initVibrator();
        addButtonListener();

    }

    private void initVibrator() {
        mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    private void addButtonListener() {
        Button vibrate = (Button) findViewById(R.id.vibrate);
        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
            }
        });


        Button vibratePattern = (Button) findViewById(R.id.vibratePattern);
        vibratePattern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrateByPattern();
            }
        });

        Button stop = (Button) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopVibration();
            }
        });

    }

    private void stopVibration() {
        mVibrator.cancel();
    }

    private void vibrateByPattern() {

        long[] pattern = {50, 100, 100, 200, 100, 300};
        mVibrator.vibrate(pattern, 1);

    }

    private void vibrate() {

        String milliSecondString = getMilliSecond();

        if(milliSecondString.equals("")) {
            Toast.makeText(this, "밀리세컨드를 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }



        mVibrator.vibrate(Long.parseLong(milliSecondString) );
    }

    private String getMilliSecond() {
        EditText userInput = (EditText) findViewById(R.id.milliSecond);
        String milliSecondString = userInput.getText().toString();




        return milliSecondString;
    }


}
