package ke.co.appslab.home.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import ke.co.appslab.home.R;
import ke.co.appslab.home.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    FragmentHomeBinding homeBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        homeBinding = FragmentHomeBinding.inflate(inflater, parent, false);
        return homeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeBinding.btnToAbout.setOnClickListener(v -> {
            NavDirections navDirections = HomeFragmentDirections.actionHomeFragmentToAboutFragment();
            Navigation.findNavController(v).navigate(navDirections);

        });

        homeBinding.btnToUsers.setOnClickListener(v ->{
            NavDirections navDirections = HomeFragmentDirections.actionHomeFragmentToUsersFragment();
            Navigation.findNavController(v).navigate(navDirections);
        });

    }
}
