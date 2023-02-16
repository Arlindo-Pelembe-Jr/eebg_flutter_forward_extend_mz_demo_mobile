package com.example.flutter_extend_mz_demo_jinigen;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

    public  static  void  openCamera(Activity mainActivity){
//        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//        mainActivity.startActivity(intent);
        final int CAMERA_PIC_REQUEST = 1337;
            mainActivity.runOnUiThread(()->{
//                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//                mainActivity.startActivity(intent);
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                mainActivity.startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
            });

    }
}
