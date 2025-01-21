package com.tom.mathproject_tom_m.mathproj;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.tom.mathproject_tom_m.R;

public class RateActivity extends AppCompatActivity {
    private Button Save;
    private SeekBar Seekbarr1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        initview();
    }

    public void initview() {
        Save=findViewById(R.id.save);
        Seekbarr1=findViewById(R.id.Seekbarr1);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn = new Intent();
                inn.putExtra("Rate123", Seekbarr1.getProgress());
                setResult(RESULT_OK,inn);
                finish();

            }

        });
    }
}
