package com.matrimony.Service;

import com.matrimony.Entities.Preferences;
import com.matrimony.Repositories.PreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreferencesService
{

    @Autowired
    private PreferencesRepository preferencesRepository;

    // save Preferences
    public Preferences savePreferences(Preferences preferences)
    {
        return preferencesRepository.save(preferences);
    }

    // getAllPreferences
    public List<Preferences> getAllPreferences()
    {
        return preferencesRepository.findAll();
    }

    // getPreferencesById
    public Optional<Preferences> getPreferencesById(Long id)
    {
        return preferencesRepository.findById(id);
    }

    //updatePreferences
    public Preferences updatePreferences(Long id, Preferences updatedPreferences)
    {
        updatedPreferences.setId(id);
        return preferencesRepository.save(updatedPreferences);
    }

     //  deletePreferences
     public void deletePreferences(Long id)
     {
         preferencesRepository.deleteById(id);
     }

}
