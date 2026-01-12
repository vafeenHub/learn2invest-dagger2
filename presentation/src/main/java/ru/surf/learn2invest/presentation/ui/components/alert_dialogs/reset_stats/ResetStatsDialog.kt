package ru.surf.learn2invest.presentation.ui.components.alert_dialogs.reset_stats

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import ru.surf.learn2invest.domain.utils.launchMAIN
import ru.surf.learn2invest.presentation.R
import ru.surf.learn2invest.presentation.databinding.SimpleDialogBinding
import ru.surf.learn2invest.presentation.di.DaggerPresentationComponent
import ru.surf.learn2invest.presentation.ui.components.alert_dialogs.parent.CustomAlertDialog
import ru.surf.learn2invest.presentation.utils.viewModelCreator
import ru.vafeen.core.di.coreComponent
import javax.inject.Inject
import javax.inject.Provider

/**
 * Диалог для сброса статистики.
 *
 * Этот диалог предоставляет пользователю возможность сбросить статистику (баланс) в приложении.
 * Включает в себя кнопки для подтверждения сброса или отмены действия.
 *
 * @constructor Инициализирует диалог с использованием ViewModel для сброса статистики.
 */

internal class ResetStatsDialog : CustomAlertDialog() {

    /**
     * Тег диалога, используемый для идентификации.
     */
    override val dialogTag: String = "ResetStatsDialog"

    /**
     * Инициализирует слушателей для кнопок в диалоге.
     *
     * Устанавливает текст для кнопки подтверждения сброса и настраивает обработчики кликов для
     * кнопок "Да, точно" и "Нет". При подтверждении сброса статистики запускается соответствующий
     * процесс через ViewModel, а диалог закрывается.
     */
    override fun initListeners(binding: SimpleDialogBinding) {

        // Обработчик для кнопки "Да, точно" — сбрасывает статистику и закрывает диалог
        binding.yesExactly.setOnClickListener {
            viewModel.handleIntent(ResetStatsDialogIntent.ResetStats)
        }

        // Обработчик для кнопки "Нет" — просто закрывает диалог
        binding.no.setOnClickListener {
            viewModel.handleIntent(ResetStatsDialogIntent.Dismiss)
        }
        viewLifecycleOwner.lifecycleScope.launchMAIN {
            viewModel.state.collectLatest { state ->
                // Устанавливаем текст для кнопки сброса статистики
                binding.text.text = state.text
            }
        }

        lifecycleScope.launchMAIN {
            viewModel.effects.collect { effect ->
                when (effect) {
                    ResetStatsDialogEffect.Dismiss -> {
                        dismiss()
                    }

                    ResetStatsDialogEffect.ToastResetStateSuccessful -> {
                        Toast.makeText(
                            requireContext(),
                            requireContext().getString(R.string.stat_reset),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }

    @Inject
    lateinit var viewModelProvider: Provider<ResetStatsDialogViewModel>

    /**
     * ViewModel для работы с логикой сброса статистики.
     */
    private val viewModel: ResetStatsDialogViewModel by viewModelCreator {
        viewModelProvider.get()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerPresentationComponent.builder().coreComponent(requireContext().coreComponent).build()
            .inject(this)
        super.onCreate(savedInstanceState)
    }
}
