package rafaelbarbosatec.poc.typepokemon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rafaelbarbosatec.sdk.data.pokemon.model.TypePokemon
import kotlinx.android.synthetic.main.item_type_pokemon.view.*
import rafaelbarbosatec.poc.typepokemon.R
import rafaelbarbosatec.poc.typepokemon.util.MyViewHolder
import rafaelbarbosatec.poc.typepokemon.util.loadFromUrl

class TypePokemonAdapter(
    private var types:ArrayList<TypePokemon> = arrayListOf(),
    val clickItem:(TypePokemon?) ->Unit
) : RecyclerView.Adapter<MyViewHolder>(){

    private var positionSelected = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_type_pokemon, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return types.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = types[position]

        with(holder.itemView){
            view_selected.visibility = View.GONE

            if(position == positionSelected){
                view_selected.visibility = View.VISIBLE
            }
            textview_all.visibility = View.GONE
            if(item.name == "all"){
                textview_all.visibility = View.VISIBLE
            }
            imageview_type_pokemon.loadFromUrl(item.thumbnailImage)
            setOnClickListener {
                positionSelected = position
                if(item.name == "all"){
                    clickItem(null)
                }else{
                    clickItem(item)
                }
                notifyDataSetChanged()
            }
        }
    }

    fun replaceData(types:ArrayList<TypePokemon>){
        val t = ArrayList<TypePokemon>()
        t.add(TypePokemon("","all"))
        t.addAll(types)
        this.types = t
        notifyDataSetChanged()
    }

}
