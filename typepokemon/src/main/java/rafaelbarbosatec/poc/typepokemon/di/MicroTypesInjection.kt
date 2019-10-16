package rafaelbarbosatec.poc.typepokemon.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rafaelbarbosatec.poc.typepokemon.PokemonTypesViewModel

object MicroTypesInjection {

    val module = module {
        viewModel { PokemonTypesViewModel(get()) }
    }

}