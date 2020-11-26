package ru.fom.myapplessons.ui.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.fom.myapplessons.MainActivity
import ru.fom.myapplessons.viewmodel.base.BaseViewModel

abstract class BaseFragment<T: BaseViewModel> : Fragment() {

    val main: MainActivity
        get() = activity as MainActivity

    protected abstract val viewModel: T
    protected abstract val layout: Int

    abstract fun setupViews()

    var filterName: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filterName = arguments?.getString("filter")

        setupViews()
    }
}