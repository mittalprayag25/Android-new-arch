package com.prayag.arch.application.util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import javax.inject.Inject;

/**
 * Created by pmittal on 25/10/17.
 */

public class AppPermission {

    Activity activity;

    @Inject
    public AppPermission(Activity activity){
        this.activity = activity;
    }

    public void takeUserPermission(int permissionCode){
        if(permissionCode == Constants.PermissionType.CAMERA_PERMISSOIN_CODE){
            if(ContextCompat.checkSelfPermission(activity, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions( activity, new String[]{android.Manifest.permission.CAMERA},permissionCode);
            }
        }

        if(permissionCode == Constants.PermissionType.STORAGE_PERMISSION_CODE){
            if(ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                Log.d("Camera","Camera permission not granted");
                ActivityCompat.requestPermissions( activity, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},permissionCode);
            }
        }
    }

}
