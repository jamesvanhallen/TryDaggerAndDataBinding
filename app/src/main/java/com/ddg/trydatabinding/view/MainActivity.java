package com.ddg.trydatabinding.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.ddg.trydatabinding.R;

import org.xelevra.architecture.base.BaseActivity;
import org.xelevra.architecture.util.Easy;

public class MainActivity extends BaseActivity {

    private final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 111;

    {
        fragmentsLayoutId = R.id.container;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkPermissions();

        DataBindingUtil.setContentView(this, R.layout.activity_main);
        if(getFragmentManager().findFragmentById(R.id.container)==null){
            getFragmentStack().replace(new MainFragment());
        }
    }

    private void checkPermissions() {
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS);
        Easy.logD("PERMISSIONS " +permissionCheck);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
                Easy.logD("PERMISSIONS GRANTED");

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Easy.logD("PERMISSIONS SUCCESS");

                } else {
                    Easy.logD("PERMISSIONS DENIED");
                }
               break;
            }

        }
    }
}
