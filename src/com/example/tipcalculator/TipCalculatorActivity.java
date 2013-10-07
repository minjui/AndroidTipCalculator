package com.example.tipcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void ButtonOnClick(View v) {
    	String tag = (String) v.getTag();
    	try {
    		double tipPct = Double.parseDouble(tag);
    		showTip(tipPct);
    	} catch (NumberFormatException e) {
    		Toast.makeText(this, "Please enter number only", Toast.LENGTH_SHORT).show();
    		return;
    	}
    }

	private void showTip(double tipPct) {
        EditText etMoney = (EditText) findViewById(R.id.etMoney);
        TextView tvTipAmt = (TextView) findViewById(R.id.tvTipAmt);

		String pattern = "$###,###.##";
		double money = Double.parseDouble(etMoney.getText().toString());
		Double a = money * tipPct;
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(a);
		String str = "Tip is: " + output;
		
		tvTipAmt.setText(str);
	}
    
}
