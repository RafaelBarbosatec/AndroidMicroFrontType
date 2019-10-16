package rafaelbarbosatec.poc.typepokemon

import com.rafaelbarbosatec.sdk.data.pokemon.model.TypePokemon

interface PokemonTypesComunication{
    interface PokemonTypesListern{
        fun pokemonTypesOnClick(type: TypePokemon?)
    }

    interface PokemonTypesAction{
    }
}