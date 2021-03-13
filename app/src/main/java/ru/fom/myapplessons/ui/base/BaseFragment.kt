package ru.fom.myapplessons.ui.base

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.android.synthetic.main.main_layout.*
import ru.fom.myapplessons.MainActivity
import ru.fom.myapplessons.utils.FILTER_NAME_MENU
import ru.fom.myapplessons.viewmodel.base.BaseViewModel

abstract class BaseFragment<T: BaseViewModel> : Fragment() {

    val main: MainActivity
        get() = activity as MainActivity

    protected abstract val viewModel: T
    protected abstract val layout: Int

    open val prepareToolbar: (ToolbarBuilder.() -> Unit)? = null

    val toolbar: MaterialToolbar
        get() = main.main_toolbar


    abstract fun setupViews()

    var filterName: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filterName = arguments?.getString(FILTER_NAME_MENU)

        main.toolbarBuilder
            .invalidate()
            .prepare(prepareToolbar)
            .build(main)

        setupViews()
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        if (main.toolbarBuilder.items.isNotEmpty()) {
            for ((index, menuHolder) in main.toolbarBuilder.items.withIndex()) {
                val item = menu.add(0, menuHolder.menuId, index, menuHolder.title)
                item.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS or MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW)
                    .setIcon(menuHolder.icon)
                    .setOnMenuItemClickListener {
                        menuHolder.clickListener?.invoke(it)?.let { true } ?: false
                    }

                if (menuHolder.actionViewLayout != null) item.setActionView(menuHolder.actionViewLayout)
            }
        } else menu.clear()
        super.onPrepareOptionsMenu(menu)
    }
}