package ru.fom.myapplessons.ui.base

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getDrawable
import androidx.core.view.children
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.circleCropTransform
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.android.synthetic.main.main_layout.*
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.MenuItemHolder
import ru.fom.myapplessons.extension.dpToIntPx
import ru.fom.myapplessons.viewmodel.base.BaseViewModel

abstract class BaseActivity<T: BaseViewModel>: AppCompatActivity() {

    protected abstract val viewModel: T
    protected abstract val layout: Int
    lateinit var navController: NavController

    val toolbarBuilder = ToolbarBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        setSupportActionBar(main_toolbar)
    }
}

class ToolbarBuilder {
    var subtitle: String? = null
    var logo: String? = null
    var visibility: Boolean = true
    val items: MutableList<MenuItemHolder> = mutableListOf()

    fun setSubtitle(subtitle: String): ToolbarBuilder {
        this.subtitle = subtitle
        return this
    }

    fun setLogo(logo: String): ToolbarBuilder {
        this.logo = logo
        return this
    }

    fun setVisibility(isVisible: Boolean): ToolbarBuilder {
        this.visibility = isVisible
        return this
    }

    fun addMenuItem(item: MenuItemHolder): ToolbarBuilder {
        this.items.add(item)
        return this
    }

    fun invalidate(): ToolbarBuilder {
        this.subtitle = null
        this.logo = null
        this.visibility = true
        this.items.clear()
        return this
    }

    fun prepare(prepareFn: (ToolbarBuilder.() -> Unit)?): ToolbarBuilder {
        prepareFn?.invoke(this)
        return this
    }

    fun build(context: FragmentActivity) {

        //show appbar if hidden due to scroll behavior
        //context.appbar.setExpanded(true, true)

        with(context.main_toolbar) {
            subtitle = this@ToolbarBuilder.subtitle
            if (this@ToolbarBuilder.logo != null) {
                val logoSize = context.dpToIntPx(40)
                val logoMargin = context.dpToIntPx(16)
                val logoPlaceholder = getDrawable(context, R.drawable.ic_launcher_foreground)

                logo = logoPlaceholder

                val logo = children.last() as? ImageView
                if (logo != null) {
                    logo.scaleType = ImageView.ScaleType.CENTER_CROP
                    (logo.layoutParams as? Toolbar.LayoutParams)?.let {
                        it.width = logoSize
                        it.height = logoSize
                        it.marginEnd = logoMargin
                        logo.layoutParams = it
                    }

                    Glide.with(context)
                            .load(this@ToolbarBuilder.logo)
                            .apply(circleCropTransform())
                            .override(logoSize)
                            .into(logo)
                }
            } else {
                logo = null
            }
        }
    }
}
