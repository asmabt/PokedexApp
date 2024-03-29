// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.example.mypokemonapp.di;

import com.example.mypokemonapp.home.MainActivity;
import com.example.mypokemonapp.home.MainActivity_MembersInjector;
import com.example.mypokemonapp.home.homePresenter;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerPokedexComponent implements PokedexComponent {
  private Provider<homePresenter> provideHomePresenterProvider;

  private MembersInjector<MainActivity> mainActivityMembersInjector;

  private DaggerPokedexComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideHomePresenterProvider =
        DoubleCheck.provider(
            PokedexModule_ProvideHomePresenterFactory.create(builder.pokedexModule));

    this.mainActivityMembersInjector =
        MainActivity_MembersInjector.create(provideHomePresenterProvider);
  }

  @Override
  public void inject(MainActivity activity) {
    mainActivityMembersInjector.injectMembers(activity);
  }

  public static final class Builder {
    private PokedexModule pokedexModule;

    private Builder() {}

    public PokedexComponent build() {
      if (pokedexModule == null) {
        throw new IllegalStateException(PokedexModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerPokedexComponent(this);
    }

    public Builder pokedexModule(PokedexModule pokedexModule) {
      this.pokedexModule = Preconditions.checkNotNull(pokedexModule);
      return this;
    }
  }
}
