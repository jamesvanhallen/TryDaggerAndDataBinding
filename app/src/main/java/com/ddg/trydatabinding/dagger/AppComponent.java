package com.ddg.trydatabinding.dagger;

import com.ddg.trydatabinding.App;
import com.ddg.trydatabinding.view.MainActivity;
import com.ddg.trydatabinding.view.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface AppComponent {

    void inject(App app);

    void inject(MainFragment fragment);

}
