package com.fatrain.android.shoppingapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int REQUEST_CODE = 1;
    private int count = 0;
    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private TextView mTextView4;
    private TextView mTextView5;
    private TextView mTextView6;
    private TextView mTextView7;
    private TextView mTextView8;
    private TextView mTextView9;
    private TextView mTextView10;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("one", mTextView1.getText().toString());
        outState.putString("two", mTextView2.getText().toString());
        outState.putString("three", mTextView3.getText().toString());
        outState.putString("four", mTextView4.getText().toString());
        outState.putString("five", mTextView5.getText().toString());
        outState.putString("six", mTextView6.getText().toString());
        outState.putString("seven", mTextView7.getText().toString());
        outState.putString("eight", mTextView8.getText().toString());
        outState.putString("nine", mTextView9.getText().toString());
        outState.putString("ten", mTextView10.getText().toString());
        outState.putInt("count", count);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView1 = findViewById(R.id.item_one);
        mTextView2 = findViewById(R.id.item_two);
        mTextView3 = findViewById(R.id.item_three);
        mTextView4 = findViewById(R.id.item_four);
        mTextView5 = findViewById(R.id.item_five);
        mTextView6 = findViewById(R.id.item_six);
        mTextView7 = findViewById(R.id.item_seven);
        mTextView8 = findViewById(R.id.item_eight);
        mTextView9 = findViewById(R.id.item_nine);
        mTextView10 = findViewById(R.id.item_ten);


        if(savedInstanceState != null){
            mTextView1.setText(savedInstanceState.getString("one"));
            mTextView2.setText(savedInstanceState.getString("two"));
            mTextView3.setText(savedInstanceState.getString("three"));
            mTextView4.setText(savedInstanceState.getString("four"));
            mTextView5.setText(savedInstanceState.getString("five"));
            mTextView6.setText(savedInstanceState.getString("six"));
            mTextView7.setText(savedInstanceState.getString("seven"));
            mTextView8.setText(savedInstanceState.getString("eight"));
            mTextView9.setText(savedInstanceState.getString("nine"));
            mTextView10.setText(savedInstanceState.getString("ten"));
            count = savedInstanceState.getInt("count");
        }
    }

    public void goSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("count", count++);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String item = data.getStringExtra(SecondActivity.EXTRA_MESSAGE);
                int count = data.getIntExtra(SecondActivity.COUNT, 0);
                itemSetup(item, count);

            }
        }
    }

    public void itemSetup(String item, int count){
        Log.e(LOG_TAG, item+"=="+count);
        switch (count){
            case 1: mTextView1.setText(item);
                break;
            case 2: mTextView2.setText(item);
                break;
            case 3: mTextView3.setText(item);
                break;
            case 4: mTextView4.setText(item);
                break;
            case 5: mTextView5.setText(item);
                break;
            case 6: mTextView6.setText(item);
                break;
            case 7: mTextView7.setText(item);
                break;
            case 8: mTextView8.setText(item);
                break;
            case 9: mTextView9.setText(item);
                break;
            case 10: mTextView10.setText(item);
                break;

        }
    }
}
