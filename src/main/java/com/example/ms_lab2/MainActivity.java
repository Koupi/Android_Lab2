package com.example.ms_lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl, bIdk;

    int number;
    boolean isFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView);
        etInput = (EditText)findViewById(R.id.editText);
        bControl = (Button)findViewById(R.id.button);
        bIdk = (Button)findViewById(R.id.button2);

        number = (int)(Math.random() * 100);
        isFinished = false;
    }

    public void onClick (View v) {
        if(!isFinished) {
            int value;
            try {
                value = Integer.parseInt(etInput.getText().toString());

                try {
                    if (value < 1 || value > 100) {
                        throw new Exception();
                    }

                    if(value < number) {
                        tvInfo.setText(getResources().getString(R.string.behind));
                    } else if (value > number) {
                        tvInfo.setText(getResources().getString(R.string.ahead));
                    } else {
                        tvInfo.setText(getResources().getString(R.string.hit));
                        bControl.setText(getResources().getString(R.string.play_more));
                        isFinished = true;
                    }
                } catch (Exception e) {
                    tvInfo.setText(getResources().getString(R.string.value_error));
                }
            } catch (Exception e) {
                tvInfo.setText(getResources().getString(R.string.input_error));
            }
        } else {
            number = (int) (Math.random() * 100);
            bControl.setText(getResources().getString(R.string.play));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            isFinished = false;
        }
        etInput.setText("");
    }

    public void onClickIdk (View v) {
        tvInfo.setText(String.valueOf(number));
        bControl.setText(getResources().getString(R.string.play_more));
        isFinished = true;
        etInput.setText("");
    }
}
