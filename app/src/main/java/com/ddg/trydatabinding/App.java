package com.ddg.trydatabinding;

import android.app.Application;

import com.ddg.trydatabinding.dagger.AppComponent;
import com.ddg.trydatabinding.dagger.AppModule;
import com.ddg.trydatabinding.dagger.DaggerAppComponent;
import com.ddg.trydatabinding.dagger.NetModule;

import org.xelevra.architecture.util.Dagger2Helper;

public class App extends Application {

    private static AppComponent appComponent;

    public static void inject(Object target) {
        Dagger2Helper.inject(AppComponent.class, appComponent, target);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent =  DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://api.learn2crack.com"))
                .build();
    }
}
