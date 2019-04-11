package com.skottie.android.stream;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public class AuthLiveData extends LiveData<FirebaseUser>  {

    private FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
        public void onAuthStateChanged(@NonNull FirebaseAuth auth) {
            FirebaseUser firebaseUser = auth.getCurrentUser();
            setValue(firebaseUser);
        }

    };
    @Override
    protected void onActive() {
        FirebaseAuth.getInstance().addAuthStateListener(authStateListener);
    }

    @Override
    protected void onInactive() {
        FirebaseAuth.getInstance().removeAuthStateListener(authStateListener);
    }

}
