import di.Inject
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.direct
import org.kodein.di.singleton
import platform.PlatformConfiguration

object PlatformSDK {

    fun init(
        configuration: PlatformConfiguration
    ) {
        val umbrellaModule = DI.Module("umbrella") {
            bind<PlatformConfiguration>() with singleton {
                configuration
            }
        }

        Inject.createDependencies(
            DI {
                importAll(
                    umbrellaModule,
                    coreModule,
                    gamesModule,
                    authModule
                )
            }.direct
        )
    }
}