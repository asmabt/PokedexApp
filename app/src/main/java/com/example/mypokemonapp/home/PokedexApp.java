package com.example.mypokemonapp.home;

import android.app.Application;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatActivity;

import com.example.mypokemonapp.BuildConfig;
import com.example.mypokemonapp.common.network.ApiManager;
import com.example.mypokemonapp.di.DaggerPokedexComponent;
import com.example.mypokemonapp.di.PokedexComponent;
import com.example.mypokemonapp.di.PokedexModule;

public class PokedexApp extends Application {
    private static PokedexApp pokedexApp;
    private PokedexComponent pokedexComponent ;
    private AppCompatActivity currentActivity;
    private AppCompatActivity previousActivity;

    public static PokedexApp getInstance() {
        if (pokedexApp == null)
            pokedexApp = new PokedexApp();

        return pokedexApp;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        pokedexApp = this;

        pokedexComponent = DaggerPokedexComponent
                .builder()
                .pokedexModule(new PokedexModule(this)) //this : application
                .build();

        ApiManager.getInstance().setupRetrofitAPI(BuildConfig.BASE_URL);
    }


    public PokedexComponent getPokedexComponent() {
        return pokedexComponent;
    }

    public AppCompatActivity getCurrentActivity() {
        return currentActivity;
    }


    public void setCurrentActivity(AppCompatActivity currentActivity) {
        if (this.currentActivity != null) {
            this.previousActivity = this.currentActivity;
        }
        this.currentActivity = currentActivity;


    }

}
