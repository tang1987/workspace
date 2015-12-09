package com.tang.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.d("first", this.toString());
        setContentView(R.layout.activity_first);
        Button buttonFinish = (Button)findViewById(R.id.firstButton);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this, "button click", Toast.LENGTH_LONG).show();
                ActivityCollector.finishAll();
            }
        });
        Button buttonNext = (Button)findViewById(R.id.secondButton);
        buttonNext.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  //startActivity(new Intent(FirstActivity.this, SecondActivity.class));
                                                  startActivity(new Intent("com.tang.activityTest.ACTION_START"));
                                              }
                                          }
        );

        Button buttonStandardStart = (Button)findViewById(R.id.StartStandardButton);
        buttonStandardStart.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              startActivity(new Intent(FirstActivity.this, FirstActivity.class));
                                              //startActivity(new Intent("com.tang.activityTest.ACTION_START"));
                                          }
                                      }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId())
        {
            case R.id.add_item:
                Toast.makeText(this, "add success", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "remove success", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        //noinspection SimplifiableIfStatement
  /*      if (id == R.id.action_settings) {
            return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }
}
