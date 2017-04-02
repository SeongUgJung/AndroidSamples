package com.nobrain.androidsamples.autovalue;


import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

@GsonTypeAdapterFactory
public abstract class MyAutovalueTypeAdapter implements TypeAdapterFactory {
    public static MyAutovalueTypeAdapter create() {
        return new AutoValueGson_MyAutovalueTypeAdapter();
    }
}
