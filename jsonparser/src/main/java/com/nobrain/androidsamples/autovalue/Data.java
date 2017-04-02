package com.nobrain.androidsamples.autovalue;


import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

@AutoValue
public abstract class Data {
    public static Builder builder() {return new AutoValue_Data.Builder();}

    public static TypeAdapter<Data> typeAdapter(Gson gson) {
        return new AutoValue_Data.GsonTypeAdapter(gson);
    }

    abstract List<User> users();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder users(List<User> users);

        public abstract Data build();
    }
}
