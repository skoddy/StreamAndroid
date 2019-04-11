package com.skottie.android.stream;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;
import javax.inject.Singleton;


public class FirebaseAuthRepository implements AuthRepository {

    @Override
    public AuthLiveData getAuthData() {
        return new AuthLiveData();
    }
}
