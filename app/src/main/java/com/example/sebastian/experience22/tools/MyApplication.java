package com.example.sebastian.experience22.tools;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Sebastian on 29/05/2015.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        printHashKey();
    }
    public void printHashKey(){
        try{
            PackageInfo info = getPackageManager().getPackageInfo("com.example.sebastian.facebooklogin", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures){
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("Keyhash: ",Base64.encodeToString(md.digest(),Base64.DEFAULT));

            }
        }catch (PackageManager.NameNotFoundException e){

        }catch (NoSuchAlgorithmException e){

        }
    }
}
