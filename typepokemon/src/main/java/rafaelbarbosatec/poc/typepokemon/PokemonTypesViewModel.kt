package rafaelbarbosatec.poc.typepokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rafaelbarbosatec.sdk.RepositorySDK
import com.rafaelbarbosatec.sdk.core.extensions.read
import com.rafaelbarbosatec.sdk.core.response.ResponseSuccess
import com.rafaelbarbosatec.sdk.data.pokemon.model.TypePokemon
import com.rafaelbarbosatec.sdk.data.pokemon.repository.PokemonRepository
import rafaelbarbosatec.poc.typepokemon.util.asMutable

class PokemonTypesViewModel(private val repository: RepositorySDK?) : ViewModel() {

    val repositoryPokemons = repository?.pokemon()
    val progress: LiveData<Boolean> = MutableLiveData()
    val types : LiveData<ArrayList<TypePokemon>> = MutableLiveData()

    fun loadPokemonTypes(){

        progress.asMutable?.value = true

        repositoryPokemons?.types { any ->
            any.read({
                types.asMutable?.value = it
            },{

            })

            progress.asMutable?.value = false
        }
    }

    override fun onCleared() {
        repositoryPokemons?.destroy()
        super.onCleared()
    }

}