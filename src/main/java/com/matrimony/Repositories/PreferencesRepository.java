package com.matrimony.Repositories;

import com.matrimony.Entities.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferencesRepository extends JpaRepository<Preferences,Long>
{
}
