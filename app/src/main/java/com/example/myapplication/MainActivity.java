package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    String mOrderMessage ="";
    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafe.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatButton = findViewById(R.id.shoppingButton);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);

            }
        });
    }


    @SuppressLint("ResourceType")
    public void imageClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.donut:
                mOrderMessage = getString(R.string.donut_order_message);
                break;
            case R.id.ice_cream:
                mOrderMessage = getString(R.string.ice_cream_order_message);
                break;
            case R.id.froyo:
                mOrderMessage = getString(R.string.froyo_order_message);
                break;
            default:
                mOrderMessage = "";
                break;
        }
        displayToast(mOrderMessage);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}