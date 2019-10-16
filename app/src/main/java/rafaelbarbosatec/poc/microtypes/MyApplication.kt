package rafaelbarbosatec.poc.microtypes

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import rafaelbarbosatec.poc.typepokemon.PokemonsTypes

class MyApplication: Application(){

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                arrayListOf(
                    AppModule.module,
                    PokemonsTypes.getModuleInjection()
                )
            )
        }
    }
}