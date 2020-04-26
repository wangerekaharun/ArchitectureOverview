package ke.co.appslab.architectureoverview.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ke.co.appslab.architectureoverview.R;
import ke.co.appslab.architectureoverview.models.Result;
import ke.co.appslab.architectureoverview.utils.CharacterClickListener;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder> {
    private List<Result> resultList;
    private CharacterClickListener characterClickListener;

    public CharactersAdapter(List<Result> results,CharacterClickListener characterClickListener){
        this.resultList = results;
        this.characterClickListener = characterClickListener;
    }
    @NonNull
    @Override
    public CharactersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character,parent, false);
        return new CharactersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersViewHolder holder, int position) {
        Result result = resultList.get(position);
        holder.nameText.setText(result.getName());
        Glide.with(holder.itemView.getContext()).load(result.getImage()).into(holder.imageView);
        holder.itemView.setOnClickListener(v ->{
            characterClickListener.onCharacterClick(result);
        });


    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class CharactersViewHolder extends RecyclerView.ViewHolder {
        private TextView nameText;
        private ImageView imageView;
        public CharactersViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.tvName);
            imageView = itemView.findViewById(R.id.imgCharacter);
        }
    }
}
