package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greatdialogs.ButtonNames;
import com.example.greatdialogs.DialogType;
import com.example.greatdialogs.GreatDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.error_dialog).setOnClickListener(v -> {
            GreatDialog dialog = new GreatDialog(MainActivity.this, DialogType.ERROR);
            dialog.setTitle("ERROR")
                    .setVibrate(true)
                    .setButtonVisibility(ButtonNames.OK, true)
                    .setButtonVisibility(ButtonNames.CANCEL,false)
                    .setMessage("We are sorry, please try again!")
                    .setOKButtonText("OK")
                    .setOkButtonColor(Color.RED)
                    .setTitleColor(Color.BLACK)
                    .setMsgColor(Color.BLACK)
                    .setOKButtonOnClickListener(this::performCustomAction).show();
        });

        findViewById(R.id.success_dialog).setOnClickListener(v -> {
            GreatDialog dialog = new GreatDialog(MainActivity.this, DialogType.SUCCESS);
            dialog.setTitle("SUCCESS")
                    .setButtonVisibility(ButtonNames.OK, true)
                    .setButtonVisibility(ButtonNames.CANCEL,false)
                    .setMessage("Yay you did it!")
                    .setOKButtonText("OK")
                    .setOkButtonColor(Color.GREEN)
                    .setOkButtonTextColor(Color.BLACK)
                    .setTitleColor(Color.BLACK)
                    .setMsgColor(Color.BLACK)
                    .setOKButtonOnClickListener(this::performCustomAction).show();
        });

        findViewById(R.id.question_dialog).setOnClickListener(v -> {
            GreatDialog dialog = new GreatDialog(MainActivity.this, DialogType.QUESTION);
            dialog.setTitle("WARNING")
                    .setButtonVisibility(ButtonNames.OK, true)
                    .setButtonVisibility(ButtonNames.CANCEL,true)
                    .setMessage("Are you sure you want to delete?")
                    .setOKButtonText("OK")
                    .setCancelButtonColor(Color.GRAY)
                    .setOkButtonColor(Color.RED)
                    .setCancelButtonTextColor(Color.WHITE)
                    .setTitleColor(Color.BLACK)
                    .setMsgColor(Color.BLACK)
                    .setOKButtonOnClickListener(this::performCustomAction).show();
        });
    }

    private void performCustomAction() {
        int x = 1;
        int y = 3;
        int z = x + y;
        Log.d("z is", z + "");
    }
}
