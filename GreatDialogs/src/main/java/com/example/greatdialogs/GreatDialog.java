package com.example.greatdialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class GreatDialog {
    private final Dialog dialog;
    private final Button cancelButton;

    private final TextView title;
    private final TextView message;
    private final Button okButton;
    private final LottieAnimationView animationView;
    private final  View space;


    public interface setOnClickListener {
        void onClick();
    }

    public GreatDialog(Context context, DialogType dialogType) {
        dialog = new Dialog(context);
        FrameLayout rootView = new FrameLayout(context);


        View view = LayoutInflater.from(context).inflate(R.layout.great_question_dialog, rootView, false);

        dialog.setContentView(view);

        title = view.findViewById(R.id.dialog_title);
        message = view.findViewById(R.id.dialog_message);
        okButton = view.findViewById(R.id.ok_button);
        cancelButton = view.findViewById(R.id.cancel_button);
        space = view.findViewById(R.id.space);
        animationView = view.findViewById(R.id.animationView);

        setAnimation(dialogType);


    }


    private void setAnimation(DialogType dialogType) {
        int animationResId = R.raw.warning;

        switch (dialogType) {
            case SUCCESS:
                animationResId = R.raw.good;
                break;
            case ERROR:
                animationResId = R.raw.error;
                break;
            case QUESTION:
                animationResId = R.raw.warning;
                break;
        }

        animationView.setAnimation(animationResId);
    }

    public GreatDialog setButtonVisibility(ButtonNames name, boolean visible) {
        switch (name) {
            case OK:
                okButton.setVisibility(visible ? View.VISIBLE : View.GONE);
                space.setVisibility(visible ? View.VISIBLE : View.GONE);
                break;
            case CANCEL:
                cancelButton.setVisibility(visible ? View.VISIBLE : View.GONE);
                space.setVisibility(visible ? View.VISIBLE : View.GONE);
                break;
        }
        return this;
    }
    public GreatDialog setTitle(String titleText) {
        title.setText(titleText);
        return this;
    }

    public GreatDialog setMessage(String messageText) {
        message.setText(messageText);
        return this;
    }

    public GreatDialog setOKButtonText(String buttonText) {
        if (okButton.getVisibility() == View.VISIBLE) {
            okButton.setText(buttonText);
        }
        return this;
    }

    public GreatDialog setOkButtonColor(int color) {
        if (okButton.getVisibility() == View.VISIBLE) {
            okButton.setBackgroundColor(color);
        }

        return this;
    }

    public GreatDialog setTitleColor(int color) {
        title.setTextColor(color);
        return this;
    }

    public GreatDialog setMsgColor(int color) {
        message.setTextColor(color);
        return this;
    }

    public GreatDialog setOkButtonTextColor(int color) {
        if (okButton.getVisibility() == View.VISIBLE) {
            okButton.setTextColor(color);
        }
        return this;
    }

    public GreatDialog setOKButtonOnClickListener(final setOnClickListener listener) {
        if (okButton.getVisibility() == View.VISIBLE) {
            okButton.setOnClickListener(v -> {
                listener.onClick();
                dialog.dismiss();
            });
        }
        return this;
    }

    public void show() {
        dialog.show();
    }

    public GreatDialog setCancelButtonText(String buttonText) {
        if (cancelButton.getVisibility() == View.VISIBLE) {
            cancelButton.setText(buttonText);
        }
        return this;
    }

    public GreatDialog setCancelButtonColor(int color) {
        if (cancelButton.getVisibility() == View.VISIBLE) {
            cancelButton.setBackgroundColor(color);
        }
        return this;
    }

    public GreatDialog setCancelButtonTextColor(int color) {
        if (cancelButton.getVisibility() == View.VISIBLE) {
            cancelButton.setTextColor(color);
        }
        return this;
    }

    public GreatDialog setCancelButtonOnClickListener(final setOnClickListener listener) {
        if (cancelButton.getVisibility() == View.VISIBLE) {
            cancelButton.setOnClickListener(v -> {
                listener.onClick();
                dialog.dismiss();
            });
        }
        return this;
    }

}
