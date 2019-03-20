package com.jiujiu.mvvmTemplate.ui.settings;

import android.os.Bundle;

import com.jiujiu.mvvmTemplate.R;

import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;

public class SettingFragment extends PreferenceFragmentCompat {

    private int count = 0;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.pref_settings, rootKey);
        setupPreference();
    }

    private void setupPreference() {
        PreferenceCategory otherCategory = findPreference("other_category");
        Preference secret_output = findPreference("secret_output");

        otherCategory.removePreference(secret_output);

        Preference secret = findPreference("secret");
        secret.setOnPreferenceClickListener(preference -> {
            if (++count >= 7) {
                otherCategory.addPreference(secret_output);
            }
            return true;
        });

        ListPreference listPreference = findPreference("sync_frequency");
        listPreference.setSummaryProvider(ListPreference.SimpleSummaryProvider.getInstance());

        EditTextPreference editTextPreference = findPreference("example_text");
        editTextPreference.setSummaryProvider(EditTextPreference.SimpleSummaryProvider.getInstance());

    }
}
