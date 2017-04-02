package com.nobrain.androidsamples.autovalue;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

@AutoValue
public abstract class User {

    public static Builder builder() {return new AutoValue_User.Builder();}

    public static TypeAdapter<User> typeAdapter(Gson gson) {
        return new AutoValue_User.GsonTypeAdapter(gson);
    }

    abstract String _id();

    abstract long index();

    abstract String guid();

    abstract boolean isActive();

    abstract String balance();

    abstract String picture();

    abstract int age();

    abstract String eyeColor();

    abstract String name();

    abstract String gender();

    abstract String company();

    abstract String email();

    abstract String phone();

    abstract String address();

    abstract String about();

    abstract String registered();

    abstract double latitude();

    abstract double longitude();

    abstract String greeting();

    abstract String favoriteFruit();

    abstract List<String> tags();

    abstract List<Friend> friends();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder _id(String _id);

        public abstract Builder index(long index);

        public abstract Builder guid(String guid);

        public abstract Builder isActive(boolean isActive);

        public abstract Builder balance(String balance);

        public abstract Builder picture(String picture);

        public abstract Builder age(int age);

        public abstract Builder eyeColor(String eyeColor);

        public abstract Builder name(String name);

        public abstract Builder gender(String gender);

        public abstract Builder company(String company);

        public abstract Builder email(String email);

        public abstract Builder phone(String phone);

        public abstract Builder address(String address);

        public abstract Builder about(String about);

        public abstract Builder registered(String registered);

        public abstract Builder latitude(double latitude);

        public abstract Builder longitude(double longitude);

        public abstract Builder greeting(String greeting);

        public abstract Builder favoriteFruit(String favoriteFruit);

        public abstract Builder tags(List<String> tags);

        public abstract Builder friends(List<Friend> friends);

        public abstract User build();
    }
}
