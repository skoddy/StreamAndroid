package com.skottie.android.stream;

import java.util.HashMap;

import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {
    private UserRepository repository;
    private UserProfileLiveData liveData;
    private HashMap cache = new HashMap<String, User>();

    public UserProfileLiveData getUserData(String uid) {
        liveData = repository.getUserData(uid);
        cache.put(uid, liveData);
        return liveData;
    }
}
