package com.example.samaire.bmi;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.*;
import java.text.DecimalFormat;



public class BmiActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bmi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void reset(View v) {
        EditText height = (EditText)findViewById(R.id.heightTextField);
        EditText weight = (EditText)findViewById(R.id.weightTextField);
        TextView bmi = (TextView)findViewById(R.id.actualBmiTextView);

        height.setText("");
        weight.setText("");
        bmi.setText("");
    }

    public void compute(View v) {
        EditText heightField = (EditText)findViewById(R.id.heightTextField);
        EditText weightField = (EditText)findViewById(R.id.weightTextField);
        TextView bmiField = (TextView)findViewById(R.id.actualBmiTextView);

        DecimalFormat numberFormat = new DecimalFormat("#.00");

        double height = Integer.parseInt(heightField.getText().toString());
        double weight = Integer.parseInt(weightField.getText().toString());

        double heightM = height / 100;

        double heightSq = heightM * heightM;


        String bmi = numberFormat.format(weight / heightSq);

        bmiField.setText(bmi);

    }
}
