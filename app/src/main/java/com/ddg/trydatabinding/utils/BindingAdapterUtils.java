package com.ddg.trydatabinding.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.ddg.trydatabinding.App;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class BindingAdapterUtils {

    private BindingAdapterUtils() {
        App.inject(this);
    }

    @Inject
    Picasso picasso;

    public static BindingAdapterUtils binder;

    @BindingAdapter("android:src")
    public static void setIcon(ImageView view, String url) {
        if (binder == null) binder = new BindingAdapterUtils();
        binder.picasso.load(url)
                .into(view);

    }
}
