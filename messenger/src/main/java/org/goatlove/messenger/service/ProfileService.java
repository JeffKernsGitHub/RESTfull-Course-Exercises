package org.goatlove.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.goatlove.messenger.database.DatabaseClass;
import org.goatlove.messenger.model.Profile;

public class ProfileService
{

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("shafai", new Profile(1L, "shafai", "Shawn", "Fairweather"));
		profiles.put("casker", new Profile(2L, "casker", "Cassie", "Kerns"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}

}
