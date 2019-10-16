package rafaelbarbosatec.poc.typepokemon.util

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions

fun AppCompatImageView.loadFromUrl(url:String){
    Glide
        .with(this)
        .asBitmap()
        .load(url)
        .transition(BitmapTransitionOptions.withCrossFade())
        .into(this)
}
