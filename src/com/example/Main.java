package com.example;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Main extends Activity {
	private EditText result;
	private ImageView logo; 
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    result = (EditText)findViewById(R.id.editText1);
	    logo = (ImageView) findViewById(R.id.imageView1);
	    logo.setImageResource(R.drawable.logo);
	    
	    findViewById(R.id.btnCoffee).setOnClickListener(new OnClickListener() {
	    public void onClick(View v) {
	      Intent intent = new Intent(Main.this, CoffeeList.class);
	      startActivityForResult(intent, 0);
	    }});
	  }
	  @Override
	  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if(data != null && data.hasExtra("Order")){
	      Toast.makeText(this, data.getStringExtra("Order") + " ordered.", Toast.LENGTH_LONG).show();
	    result.setText(data.getStringExtra("Order"));
	    }
	    else
	      Toast.makeText(this, "Nothing ordered!", Toast.LENGTH_LONG).show();
	  }
	}