package com.fatrain.android.shoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "item";
    public final static String COUNT = "count";
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        count = getIntent().getIntExtra("count", 0);
        final ListView listView = findViewById(R.id.list_item);
        String[] values = new String[]{"Apple", "Mango", "Malta", "Cherry", "Orange", "Banana", "Guava", "Cheese", "Lemon",
                "Black Berry", "Jack Fruit", "Watermelon", "Dragon Fruit", "Straw Berry"};
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);

        }


        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra(EXTRA_MESSAGE, item);
                intent.putExtra(COUNT, count);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}
