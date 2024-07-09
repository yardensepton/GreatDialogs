package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greatdialogs.ButtonNames;
import com.example.greatdialogs.DialogType;
import com.example.greatdialogs.GreatDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.show_dialog_button).setOnClickListener(v -> {
            GreatDialog dialog = new GreatDialog(MainActivity.this, DialogType.ERROR);
            dialog.setTitle("ERROR")
                    .setButtonVisibility(ButtonNames.OK, true)
                    .setButtonVisibility(ButtonNames.CANCEL,false)
                    .setMessage("We are sorry, please try again!")
                    .setOKButtonText("OK")
                    .setOkButtonColor(Color.RED)
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
