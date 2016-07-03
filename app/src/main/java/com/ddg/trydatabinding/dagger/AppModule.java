package com.ddg.trydatabinding.dagger;

import com.ddg.trydatabinding.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    App mApp;

    public AppModule(App application) {
        mApp = application;
    }

    @Provides
    @Singleton
    App providesApplication() {
        return mApp;
    }
}
