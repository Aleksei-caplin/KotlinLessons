package ru.fom.myapplessons.ui.civilization

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_civilazation_single.*
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.MenuItemHolder
import ru.fom.myapplessons.ui.base.BaseFragment
import ru.fom.myapplessons.ui.base.ToolbarBuilder
import ru.fom.myapplessons.viewmodel.base.ViewModelFactory
import ru.fom.myapplessons.viewmodel.civilization.CivilizationViewModel
import ru.fom.myapplessons.viewmodel.civilization.CivilizationsViewModel

class CivilizationSingleFragment: BaseFragment<CivilizationViewModel>() {

    private val args: CivilizationSingleFragmentArgs by navArgs()

    override val layout: Int = R.layout.fragment_civilazation_single
    override val viewModel: CivilizationViewModel by viewModels{
        ViewModelFactory (
            owner = this,
            params = 4
        )
    }

    override val prepareToolbar: (ToolbarBuilder.() -> Unit) = {
        setSubtitle("fff")
        addMenuItem(
            MenuItemHolder(
                "Search",
                R.id.action_search,
                R.drawable.ic_baseline_search_24,
                R.layout.search_view_layout
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun setupViews() {
        tv_civilization_name.text = args.name
    }

}