package com.skottie.android.stream;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public interface UserRepository {
    UserProfileLiveData getUserData(String uid);
}

class FirestoreUserDataRepository implements UserRepository {

    // Should use DI
    private FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    private DocumentReference docRef;
    @Override
    public UserProfileLiveData getUserData(String uid) {
        docRef = firestore.collection("users").document(uid);
        return new UserProfileLiveData(docRef);
    }
}