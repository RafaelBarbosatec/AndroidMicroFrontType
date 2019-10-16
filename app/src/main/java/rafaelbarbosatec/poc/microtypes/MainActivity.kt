package rafaelbarbosatec.poc.microtypes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rafaelbarbosatec.sdk.RepositoryBuilder
import com.rafaelbarbosatec.sdk.data.pokemon.model.TypePokemon
import rafaelbarbosatec.poc.typepokemon.PokemonTypesComunication
import rafaelbarbosatec.poc.typepokemon.PokemonsTypes

class MainActivity : AppCompatActivity(), PokemonTypesComunication.PokemonTypesListern {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PokemonsTypes.show(supportFragmentManager,R.id.container_type,this)

    }

    override fun pokemonTypesOnClick(type: TypePokemon?) {
    }

}
