package ru.surf.learn2invest.data.cryptography

import dagger.Module
import dagger.Provides
import ru.surf.learn2invest.domain.cryptography.FingerprintAuthenticator
import ru.surf.learn2invest.domain.cryptography.PasswordHasher

@Module
internal class CryptographyDIModule {

    @Provides
    fun bindFingerprintAuthenticator(
        impl: FingerprintAuthenticatorImpl
    ): FingerprintAuthenticator = impl

    @Provides
    fun providePasswordHasher(impl: PasswordHasherImpl): PasswordHasher = impl
}
