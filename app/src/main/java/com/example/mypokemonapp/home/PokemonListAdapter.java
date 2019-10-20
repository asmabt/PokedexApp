package com.example.mypokemonapp.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.Utils.Constants;
import com.example.mypokemonapp.common.pokedexBase.PokedexBaseViewHolder;
import com.example.mypokemonapp.models.PokedexItem;
import com.example.mypokemonapp.models.ResultsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.ViewHolder> {

    Context context ;
    List<ResultsItem> items;

    public PokemonListAdapter(Context context, List<ResultsItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
       ViewHolder viewHolder =  new ViewHolder(view);
       return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonListAdapter.ViewHolder holder, int position) {
        holder.pokemonName.setText(items.get(position).getName());
        Picasso.with(context).load(Constants.Images_URL+(position+1)+".png").into(holder.pokemonImage);


    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    void setPokemonList(List<ResultsItem> resultsItems){
        this.items = resultsItems ;
        notifyDataSetChanged();
    }
    public class ViewHolder extends PokedexBaseViewHolder<PokedexItem<ResultsItem>> {

        @BindView(R.id.item_image)
        ImageView pokemonImage ;
        @BindView(R.id.item_name)
        TextView pokemonName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        @Override
        protected void bind(final PokedexItem<ResultsItem> item){
            ResultsItem resultsItem = item.getObject();
            if(resultsItem != null){
                Picasso.with(context).load(resultsItem.getUrl()).into(pokemonImage);
                pokemonName.setText(resultsItem.getName());

            }
        }
    }
}
