package com.example.a7app.presentation.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.example.a7app.presentation.utils.UIState
import com.example.a7app.presentation.utils.toastShort
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment<Binding : ViewBinding, ViewModel : BaseViewModel>(
    @LayoutRes layoutId: Int
) :
    Fragment(layoutId) {
    protected abstract val binding: Binding
    protected abstract val viewModel: ViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setRequests()
        setSubscribers()
        initListeners()
    }

    protected open fun initListeners() {}

    protected open fun setSubscribers() {}

    protected open fun setRequests() {}

    protected open fun init() {}

    protected fun <T> StateFlow<UIState<T>>.collectUIState(
        uiState: ((UIState<T>) -> Unit)? = null,
      // потом доработать  onLoading: () -> Unit,
        onSuccess: (data: T) -> Unit,
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@collectUIState.collect { state ->
                    uiState?.invoke(state)
                    when (state) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            requireActivity().toastShort(state.message)
                        }
                        is UIState.Loading -> {}
                        is UIState.Success -> {
                            onSuccess(state.data)
                        }
                    }
                }
            }
        }
    }
}