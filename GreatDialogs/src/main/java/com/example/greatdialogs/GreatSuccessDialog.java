package com.example.greatdialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


public class GreatSuccessDialog {
    private final Dialog dialog;
    private final TextView title;
    private final TextView message;
    private final Button button;



    public interface OnClickListener {
        void onClick();
    }

    public GreatSuccessDialog(Context context) {
        dialog = new Dialog(context);
        FrameLayout rootView = new FrameLayout(context);

        View view = LayoutInflater.from(context).inflate(R.layout.great_success_dialog,  rootView, false);
        dialog.setContentView(view);

        title = view.findViewById(R.id.dialog_title);
        message = view.findViewById(R.id.dialog_message);
        button = view.findViewById(R.id.dialog_button);

    }


    public GreatSuccessDialog setTitle(String titleText) {
        title.setText(titleText);
        return this;
    }

    public GreatSuccessDialog setMessage(String messageText) {
        message.setText(messageText);
        return this;
    }

    public GreatSuccessDialog setButtonText(String buttonText) {
        button.setText(buttonText);
        return this;
    }

    public GreatSuccessDialog setButtonColor(int color) {
        button.setBackgroundColor(color);
        return this;
    }

    public GreatSuccessDialog setTitleColor(int color) {
        title.setTextColor(color);
        return this;
    }

    public GreatSuccessDialog setMsgColor(int color) {
        message.setTextColor(color);
        return this;
    }
    public GreatSuccessDialog setTextColor(int color) {
        button.setTextColor(color);
        return this;
    }

    public GreatSuccessDialog setOnClickListener(final OnClickListener listener) {
        button.setOnClickListener(v -> {
            listener.onClick();
            dialog.dismiss();
        });
        return this;
    }

    public void show() {
        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }
}
