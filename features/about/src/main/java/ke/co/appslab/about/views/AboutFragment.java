package ke.co.appslab.about.views;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ke.co.appslab.about.R;
import ke.co.appslab.about.databinding.FragmentAboutBinding;
import ke.co.appslab.core.models.User;

public class AboutFragment extends Fragment {
    AboutViewModel aboutViewModel;
    FragmentAboutBinding fragmentAboutBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        fragmentAboutBinding = FragmentAboutBinding.inflate(inflater, parent, false);
        return fragmentAboutBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        aboutViewModel = new ViewModelProvider(this).get(AboutViewModel.class);
        aboutViewModel.userMutableLiveData.observe(this, user -> {
           fragmentAboutBinding.tvAbout.setText(user.getName());
        });


        getUser();
    }

    private void getUser() {
        aboutViewModel.getUser();
    }
}
