package com.ddg.trydatabinding.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.ddg.trydatabinding.R;
import org.xelevra.architecture.base.BaseActivity;

public class MainActivity extends BaseActivity {

    {
        fragmentsLayoutId = R.id.container;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);
        if(getFragmentManager().findFragmentById(R.id.container)==null){
            getFragmentStack().replace(new MainFragment());
        }
    }
}
