// Generated code from Butter Knife. Do not modify!
package com.example.mypokemonapp.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mypokemonapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PokemonListAdapter$ViewHolder_ViewBinding implements Unbinder {
  private PokemonListAdapter.ViewHolder target;

  @UiThread
  public PokemonListAdapter$ViewHolder_ViewBinding(PokemonListAdapter.ViewHolder target, View source) {
    this.target = target;

    target.pokemonImage = Utils.findRequiredViewAsType(source, R.id.item_image, "field 'pokemonImage'", ImageView.class);
    target.pokemonName = Utils.findRequiredViewAsType(source, R.id.item_name, "field 'pokemonName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PokemonListAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.pokemonImage = null;
    target.pokemonName = null;
  }
}
