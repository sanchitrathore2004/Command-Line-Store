package com.sanchit.Database.connection.services;

import com.sanchit.Database.connection.entities.Profile;
import com.sanchit.Database.connection.entities.User;
import com.sanchit.Database.connection.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProfileService {
    private ProfileRepository profileRepository;
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }
    private void addProfileToUser(User user, Profile profile){
        user.setProfile(profile);
        profile.setUser(user);
    }
    public void updateProfile(String email, String password, String bio, String phoneNumber, String dateOfBirth, UserService userService){
        User user = userService.getUserByEmail(email);
        if(user == null) {
            System.out.println("User not found");
            return;
        }
        if(!user.getPassword().equals(password)){
            System.out.println("Wrong password");
            return;
        }
        Profile profile = new Profile();
        profile.setBio(bio);
        profile.setPhoneNumber(phoneNumber);
        profile.setLoyaltyPoints((int) (Math.random()*100));
        profile.setDateOfBirth(LocalDate.of(Integer.parseInt(dateOfBirth.substring(0, 4)), Integer.parseInt(dateOfBirth.substring(4, 6)), Integer.parseInt(dateOfBirth.substring(6, 8))));
        addProfileToUser(user, profile);
        profileRepository.save(profile);
        System.out.println("Profile updated successfully");
    }
    public void showProfilesAboveLoyaltyPoints(int minLoyaltyPoints){
        List<Profile> profiles = profileRepository.getProfileAboveLoyaltyPoints(minLoyaltyPoints);
        for(Profile profile : profiles){
            System.out.println("User ID: "+profile.getId()+" "+"Email: "+profile.getUser().getEmail());
        }
    }
}
