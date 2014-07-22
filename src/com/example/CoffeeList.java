package com.example;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CoffeeList extends ListActivity{
	  @Override
	  public void onCreate(Bundle savedState) {
	    super.onCreate(savedState);
	   
	    String[] coffeeChoices = this.getResources().getStringArray(R.array.coffeeMenu);
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, coffeeChoices);
	    setListAdapter(adapter);  
	  }
	  @Override
	  protected void onListItemClick(ListView l, View v, int position, long id) {
	    String item = (String) getListAdapter().getItem(position);
	    Intent data = new Intent();
	    data.putExtra("Order",item);
	    setResult(RESULT_OK, data);
	    finish();
	  }
	}