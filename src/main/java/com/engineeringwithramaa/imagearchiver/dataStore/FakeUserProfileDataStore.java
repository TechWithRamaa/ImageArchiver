package com.engineeringwithramaa.imagearchiver.dataStore;

import com.engineeringwithramaa.imagearchiver.profile.UserProfile;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Ana ", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Tara ", null));
    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}
