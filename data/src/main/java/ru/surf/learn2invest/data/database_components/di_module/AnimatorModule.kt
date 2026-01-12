package ru.surf.learn2invest.data.database_components.di_module

import dagger.Module
import dagger.Provides
import ru.surf.learn2invest.data.animator.CustomAnimatorImpl
import ru.surf.learn2invest.domain.animator.CustomAnimator

@Module
internal class AnimatorModule {

    @Provides
    fun provideAnimator(impl: CustomAnimatorImpl): CustomAnimator = impl
}