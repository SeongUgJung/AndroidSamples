package com.nobrain.androidsamples.autovalue;


import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class Friend {

    public static Builder builder() {return new AutoValue_Friend.Builder();}

    public static TypeAdapter<Friend> typeAdapter(Gson gson) {
        return new AutoValue_Friend.GsonTypeAdapter(gson);
    }

    abstract long id();

    abstract String name();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(long id);

        public abstract Builder name(String name);

        public abstract Friend build();
    }
}
