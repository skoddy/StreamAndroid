package com.skottie.android.stream;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

class AuthViewModel extends ViewModel {

    private AuthRepository repository;



    AuthLiveData getAuthData() {
        return repository.getAuthData();
    }
}
