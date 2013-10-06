package com.example.tipcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void ButtonOnClick(View v) {
    	double tipPct;
    	switch (v.getId()) {
    		case R.id.btn10pct:
    			tipPct = 0.1;
    			break;
    		case R.id.btn15pct:
    			tipPct = 0.15;
    			break;
    		case R.id.btn20pct:
    			tipPct = 0.2;
    			break;
    		default:
    			throw new RuntimeException("unknown button ID");
    	}
    	showTip(tipPct);
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
