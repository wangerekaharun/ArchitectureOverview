package ke.co.appslab.architectureoverview.ui.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import ke.co.appslab.architectureoverview.R;
import ke.co.appslab.architectureoverview.data.datastates.CharactersState;
import ke.co.appslab.architectureoverview.databinding.FragmentCharactersBinding;
import ke.co.appslab.architectureoverview.models.CharactersResponse;
import ke.co.appslab.architectureoverview.models.Result;
import ke.co.appslab.architectureoverview.ui.adapters.CharactersAdapter;
import ke.co.appslab.architectureoverview.ui.viewmodels.CharactersViewModel;
import ke.co.appslab.architectureoverview.utils.CharacterClickListener;

public class CharacterFragment extends Fragment implements CharacterClickListener {
    private FragmentCharactersBinding fragmentCharactersBinding;
    private CharactersViewModel charactersViewModel;

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        fragmentCharactersBinding = FragmentCharactersBinding.inflate(inflater, container, false);
        View view = fragmentCharactersBinding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        charactersViewModel = new ViewModelProvider(this).get(CharactersViewModel.class);

        fetchCharacters();
        observerLiveData();

    }

    private void fetchCharacters() {
        charactersViewModel.fetchAllCharacters();
    }

    private void observerLiveData() {
        charactersViewModel.charactersStateMutableLiveData.observe(getViewLifecycleOwner(), new Observer<CharactersState>() {
            @Override
            public void onChanged(CharactersState charactersState) {
                if (charactersState.getCharactersResponse() != null){
                    initView(charactersState.getCharactersResponse());
                }else {
                    handleError(charactersState.getThrowable());
                }
            }
        });
    }

    private void handleError(Throwable throwable) {
        Toast.makeText(getContext(),throwable.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
    }

    private void initView(CharactersResponse charactersResponse) {
        CharactersAdapter adapter = new CharactersAdapter(charactersResponse.getResults(),this);
        fragmentCharactersBinding.rvCharacters.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentCharactersBinding = null;
    }

    @Override
    public void onCharacterClick(Result result) {
        Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailsFragment(result));
    }
}
