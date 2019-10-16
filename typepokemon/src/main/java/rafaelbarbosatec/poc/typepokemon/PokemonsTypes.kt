package rafaelbarbosatec.poc.typepokemon


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel
import kotlinx.android.synthetic.main.fragment_types_pokemons.*
import org.koin.core.module.Module
import rafaelbarbosatec.poc.typepokemon.adapter.TypePokemonAdapter
import rafaelbarbosatec.poc.typepokemon.di.MicroTypesInjection
import rafaelbarbosatec.poc.typepokemon.util.listen

class PokemonsTypes : Fragment() {

    companion object{
        var listener: PokemonTypesComunication.PokemonTypesListern? = null
        var actions: PokemonTypesComunication.PokemonTypesAction? = null

        fun show(fragMagaer: FragmentManager, @IdRes container:Int,listener: PokemonTypesComunication.PokemonTypesListern){
            this.listener = listener
            val ft = fragMagaer.beginTransaction()
            ft.replace(container, PokemonsTypes())
            ft.commit()
        }

        fun getModuleInjection(): Module{
            return MicroTypesInjection.module
        }
    }

    private val viewModel : PokemonTypesViewModel by viewModel()

    private val adapter = TypePokemonAdapter(arrayListOf()) {
        listener?.pokemonTypesOnClick(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_types_pokemons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservers()
        viewModel.loadPokemonTypes()
    }

    private fun initObservers() {
        viewModel.types.listen(this){
            adapter.replaceData(it)
        }
        viewModel.progress.listen(this){
            progress_circular.visibility = if(it){
                View.VISIBLE
            }else{
                View.GONE
            }
        }
    }

    override fun onResume() {
        listernAction()
        super.onResume()
    }

    private fun initView() {
        recyclerview_types_pokemon.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        recyclerview_types_pokemon.adapter = adapter
    }

    private fun listernAction(){
        actions = object :  PokemonTypesComunication.PokemonTypesAction{

        }
    }
}
