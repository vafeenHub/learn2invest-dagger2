package ru.surf.learn2invest.presentation.ui.components.screens.fragments.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import ru.surf.learn2invest.domain.utils.launchMAIN
import ru.surf.learn2invest.presentation.databinding.FragmentHistoryBinding
import ru.surf.learn2invest.presentation.di.DaggerPresentationComponent
import ru.surf.learn2invest.presentation.ui.components.screens.fragments.common.BaseResFragment
import ru.surf.learn2invest.presentation.utils.viewModelCreator
import ru.vafeen.core.di.coreComponent
import javax.inject.Inject
import javax.inject.Provider

/**
 * Фрагмент, отображающий историю сделок. Является частью экрана [ru.surf.learn2invest.presentation.ui.components.screens.host.HostActivity].
 * В данном фрагменте отображается список транзакций пользователя.
 */
internal class HistoryFragment : BaseResFragment() {
    @Inject
    lateinit var viewModelProvider: Provider<HistoryFragmentViewModel>
    private val viewModel: HistoryFragmentViewModel by viewModelCreator {
        viewModelProvider.get()
    }

    @Inject
    lateinit var adapter: HistoryFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerPresentationComponent
            .builder()
            .coreComponent(requireContext().coreComponent)
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHistoryBinding.inflate(inflater, container, false)
        initListeners(binding)
        return binding.root
    }

    private fun initListeners(binding: FragmentHistoryBinding) {
        binding.historyRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.historyRecyclerview.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launchMAIN {
            viewModel.state.collect {
                val data = it.data
                if (data.isEmpty()) {
                    binding.historyRecyclerview.isVisible = false
                    binding.noActionsTv.isVisible = true
                } else {
                    adapter.data = data
                }
            }
        }
    }
}
