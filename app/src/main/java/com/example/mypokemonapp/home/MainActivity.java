package com.example.mypokemonapp.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.di.PokedexComponent;
import com.example.mypokemonapp.models.ResultsItem;
import com.example.mypokemonapp.models.requests.PokedexRQ;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HomeView {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    homePresenter presenter;
    private PokemonListAdapter pokemonListAdapter;
    private PokedexRQ pokedexRQ = new PokedexRQ();


    private List<ResultsItem> resultsItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PokedexApp.getInstance().setCurrentActivity(this);
        ButterKnife.bind(this);
        PokedexApp.getInstance().getPokedexComponent().inject(this);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        pokemonListAdapter = new PokemonListAdapter(this, resultsItems);
        recyclerView.setAdapter(pokemonListAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
           /*@Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }*/

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy>0){
                   presenter.getPokemonData(pokedexRQ);
                }
            }
        });

        presenter.bind(this);
        presenter.getPokemonData(pokedexRQ);
    }

    @Override
    public void getPokemonList(List<ResultsItem> pokemonList) {
        resultsItems.addAll(pokemonList);
        pokemonListAdapter.setPokemonList(resultsItems);
        pokedexRQ.setOffset(pokedexRQ.getOffset()+20);

    }

    @Override
    public void showError() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
