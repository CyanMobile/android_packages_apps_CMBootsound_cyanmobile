package com.cyanogenmod.cmbootsound;

import android.os.Bundle;
import android.os.Environment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.cyanogenmod.cmbootsound.R;


public class copyReceiver extends BroadcastReceiver {

    public static final String cpyUi = "com.cyanogenmod.cmbootsound.RESET_SOUND";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(cpyUi)) {
            String fileName = "poweron.ogg";
            File rmFile = new File(context.getFilesDir(), fileName);
            if (rmFile.exists()) {
                try {
                    rmFile.delete();
                    Toast.makeText(context, R.string.remove_ui, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(context, "Error deleting poweron.ogg\n\n"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}

