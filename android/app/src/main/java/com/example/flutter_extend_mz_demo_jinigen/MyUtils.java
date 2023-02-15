package com.example.flutter_extend_mz_demo_jinigen;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;
import androidx.annotation.Keep;


@Keep
public abstract class MyUtils {
    private MyUtils() {}

    public static void showToast(Activity mainActivity, CharSequence text, int duration) {
        mainActivity.runOnUiThread(() -> Toast.makeText(mainActivity, text, duration).show());
    }

    public  static int sum(){
        return  1+1;
    }

    public  static int sum(int num1,int num2){
        return  num1+num2;
    }

    public  static  void showAlertDialog(Activity mainActivity){
        mainActivity.runOnUiThread(()->{
            AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);

            builder.setMessage("Here come the message")
                    .setTitle("Here come the title");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked OK button
                    Toast.makeText(mainActivity, "Clicked", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User cancelled the dialog
                }
            });
            AlertDialog dialog = builder.create();

            dialog.show();
        });

    }
}
