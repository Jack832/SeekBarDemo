package com.example.test4.slider;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
private static SeekBar s1;
    private static TextView t1;
    private static CheckBox ch1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ch1=(CheckBox)findViewById(R.id.chec1);
        ch1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox) v).isChecked()) {
                            s1.setEnabled(false);
                        } else {
                            s1.setEnabled(true);
                        }
                    }
                }
        );
        seekbar();




    }

   /* public void Checkboxx()
    {
        ch1=(CheckBox)findViewById(R.id.chec1);
       ch1.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       if(((CheckBox)v).isChecked())
                       {
                           s1.setEnabled(false);
                       }
                       else {
                           s1.setEnabled(true);
                       }
                   }
               }
       );
    }*/

        public void seekbar ()
        {
            s1 = (SeekBar) findViewById(R.id.seekBar);
            t1 = (TextView) findViewById(R.id.text);
            t1.setText("Covered :" + s1.getProgress() + "/" + s1.getMax());

            s1.setOnSeekBarChangeListener(
                    new OnSeekBarChangeListener() {
                        int progress_value;

                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                            progress_value = progress;
                            t1.setText("Covered :" + progress + "/" + s1.getMax());
                            Toast.makeText(MainActivity.this, "seekbar in progress", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                            Toast.makeText(MainActivity.this, "seekbar in Touch", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                            t1.setText("Covered :" + progress_value + "/" + s1.getMax());
                            Toast.makeText(MainActivity.this, "seekbar in StopTrackingTouch ", Toast.LENGTH_SHORT).show();
                        }
                    });
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
