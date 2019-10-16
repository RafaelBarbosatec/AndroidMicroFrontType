package rafaelbarbosatec.poc.typepokemon.di

import com.rafaelbarbosatec.sdk.RepositorySDK
import com.rafaelbarbosatec.sdk.data.pokemon.repository.PokemonRepository

object CreateMicroTypesModules {

    fun pokemonRepository(sdk:RepositorySDK): PokemonRepository{
        return sdk.pokemon()
    }

}