package com.example.tipcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private EditText etMoney;
	private TextView tvTipAmt;
	private double money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        etMoney = (EditText) findViewById(R.id.etMoney);
        
        tvTipAmt = (TextView) findViewById(R.id.tvTipAmt);
        
        Button b10 = (Button) findViewById(R.id.btn10pct);
        Button b15 = (Button) findViewById(R.id.btn15pct);
        Button b20 = (Button) findViewById(R.id.btn20pct);
        b10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				double tipPct = 0.1;
				showTip(tipPct);
			}
		});
        b15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				double tipPct = 0.15;
				showTip(tipPct);
			}
		});
        b20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				double tipPct = 0.2;
				showTip(tipPct);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	private void showTip(double tipPct) {
		String pattern = "$###,###.##";
		money = Double.parseDouble(etMoney.getText().toString());
		Double a = money * tipPct;
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(a);
		String str = "Tip is: " + output;
		
		tvTipAmt.setText(str);
	}
    
}
