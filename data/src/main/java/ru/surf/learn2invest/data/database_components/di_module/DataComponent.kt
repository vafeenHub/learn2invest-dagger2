package ru.surf.learn2invest.data.database_components.di_module

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.vafeen.core.di.CoreComponent
import ru.vafeen.core.di.CoreScope

@Component(
    modules = [AnimatorModule::class,
        CryptographyDIModule::class,
        DaoDiModule::class,
        DatabaseDIModule::class,
        NetworkDIModule::class,
        RepositoryDiModule::class,
        ServicesModule::class,
        SingletonServices::class]
)
@CoreScope
interface DataComponent : CoreComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): DataComponent
    }
}