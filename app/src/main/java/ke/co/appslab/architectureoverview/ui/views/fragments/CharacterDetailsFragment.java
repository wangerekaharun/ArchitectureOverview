package ke.co.appslab.architectureoverview.ui.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import ke.co.appslab.architectureoverview.databinding.FragmentCharacterDetailsBinding;
import ke.co.appslab.architectureoverview.databinding.FragmentCharactersBinding;
import ke.co.appslab.architectureoverview.models.Result;

public class CharacterDetailsFragment extends Fragment {
    private FragmentCharacterDetailsBinding characterDetailsBinding;
    Result result;

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        characterDetailsBinding = FragmentCharacterDetailsBinding.inflate(inflater, container, false);
        View view = characterDetailsBinding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        result = CharacterDetailsFragmentArgs.fromBundle(getArguments()).getResult();
        setupViews(result);

    }

    private void setupViews(Result result) {
        Glide.with(getContext()).load(result.getImage()).into(characterDetailsBinding.bannerImgView);
        characterDetailsBinding.nameTxtView.setText(result.getName());
        characterDetailsBinding.genderTxtView.setText(result.getGender());
        characterDetailsBinding.statusTxtView.setText(result.getStatus());
        characterDetailsBinding.typeTxtView.setText(result.getType());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        characterDetailsBinding = null;
    }
}
