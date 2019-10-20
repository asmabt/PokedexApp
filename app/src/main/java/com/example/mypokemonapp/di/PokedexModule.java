package com.example.mypokemonapp.di;

import android.content.Context;

import com.example.mypokemonapp.home.homePresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PokedexModule {
    private Context context;

    public PokedexModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context providesAppContext() {
        return this.context;
    }

    @Provides
    @Singleton
    homePresenter provideHomePresenter(){return new homePresenter();}
}
