package rafaelbarbosatec.poc.microtypes

import com.rafaelbarbosatec.sdk.RepositoryBuilder
import org.koin.dsl.module

object AppModule {

    val module = module {
        single {
            RepositoryBuilder(get())
                .baseUrl("https://vortigo.blob.core.windows.net/")
                .debugable(true)
                .build()
        }
    }
}