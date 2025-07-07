package com.matrimony.Controller;


import com.matrimony.Entities.Preferences;
import com.matrimony.Service.PreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/preferences")
public class PreferencesController
{
    @Autowired
    private PreferencesService preferencesService;


    @PostMapping
    public Preferences createPreferences(@RequestBody Preferences preferences)
    {
        return preferencesService.savePreferences(preferences);
    }

    @GetMapping
    public List<Preferences> getAllPreferences()
    {
        return preferencesService.getAllPreferences();
    }

    @GetMapping("/{id}")
    public Optional<Preferences> getPreferencesById(@PathVariable Long id)
    {
        return preferencesService.getPreferencesById(id);
    }


    @PutMapping("/{id}")
    public Preferences updatePreferences(@PathVariable Long id, @RequestBody Preferences preferences)
    {
        return preferencesService.updatePreferences(id, preferences);
    }

    @DeleteMapping("/{id}")
    public String deletePreferences(@PathVariable Long id)
    {
        preferencesService.deletePreferences(id);
        return "Preferences deleted successfully for ID: " + id;
    }
}
