package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greatdialogs.GreatSuccessDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.show_dialog_button).setOnClickListener(v -> new GreatSuccessDialog(MainActivity.this)
                .setTitle("Success")
                .setMessage("The item was added to the list!")
                .setButtonText("OK")
                .setTitleColor(Color.BLACK)
                .setMsgColor(Color.BLACK)
                .setButtonColor(Color.GREEN)
                .setTextColor(Color.BLACK)
                .setOnClickListener(this::performCustomAction)
                .show());
    }

    private void performCustomAction() {
        int x= 1;
        int y = 3;
        int z = x+y;
        Log.d("z is",z+"");
    }
}
