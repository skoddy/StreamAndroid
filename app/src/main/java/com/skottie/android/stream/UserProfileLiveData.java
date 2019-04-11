package com.skottie.android.stream;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

public class UserProfileLiveData extends LiveData<User> implements EventListener<DocumentSnapshot> {
    DocumentReference docRef;
    @Nullable
    private ListenerRegistration listenerRegistration = null;
    private User model;

    public UserProfileLiveData(DocumentReference docRef) {
        this.docRef = docRef;
    }

    @Override
    protected void onActive() {
        listenerRegistration = docRef.addSnapshotListener(this);
    }

    @Override
    protected void onInactive() {
        listenerRegistration.remove();
    }

    @Override
    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
        if (documentSnapshot != null && documentSnapshot.exists()) {
            model = new User();
            model.displayName = documentSnapshot.get("displayName").toString();
            setValue(model);
        }
    }
}
