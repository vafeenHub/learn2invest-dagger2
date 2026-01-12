package ru.surf.learn2invest.presentation.ui.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import ru.surf.learn2invest.domain.utils.launchMAIN
import ru.surf.learn2invest.presentation.databinding.ActivityMainBinding
import ru.surf.learn2invest.presentation.di.DaggerPresentationComponent
import ru.surf.learn2invest.presentation.utils.viewModelCreator
import ru.vafeen.core.di.coreComponent
import javax.inject.Inject
import javax.inject.Provider


internal class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelProvider: Provider<MainActivityViewModel>
    private val viewModel: MainActivityViewModel by viewModelCreator {
        viewModelProvider.get()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerPresentationComponent
            .builder()
            .coreComponent(applicationContext.coreComponent)
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        initListeners()
        viewModel.handleIntent(MainActivityIntent.ProcessSplash(binding.splashTextView))
    }

    private fun initListeners() {
        lifecycleScope.launchMAIN {
            viewModel.effects.collect { effect ->
                when (effect) {
                    MainActivityEffect.Finish -> this@MainActivity.finish()
                    is MainActivityEffect.StartIntent -> startActivity(effect.creating(this@MainActivity))
                }
            }
        }
    }

}
