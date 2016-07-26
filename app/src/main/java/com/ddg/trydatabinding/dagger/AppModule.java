package com.ddg.trydatabinding.dagger;

import com.ddg.trydatabinding.App;
import com.squareup.picasso.Picasso;

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

    @Provides
    @Singleton
    Picasso picasso (App application){
        return Picasso.with(application);
    }
}
