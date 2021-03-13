package ru.fom.myapplessons.data

import android.view.MenuItem
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

data class MenuItemHolder(
        val title: String,
        @IdRes val menuId: Int,
        @DrawableRes val icon: Int,
        @LayoutRes val actionViewLayout: Int? = null,
        val clickListener: ((MenuItem) -> Unit)? = null
)