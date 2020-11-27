package ru.fom.myapplessons.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Checkable
import android.widget.ImageView

class CheckableImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr), Checkable, View.OnClickListener{

    private var checked = false

    init {
        setOnClickListener(this)
    }

    override fun setChecked(check: Boolean) {
        if(checked == check) return
        checked = check
        refreshDrawableState()
    }

    override fun isChecked(): Boolean = checked

    override fun toggle() {
        isChecked = !checked
    }

    override fun onClick(v: View?) {
        Log.d("M_ff", "ok")
        toggle()
    }

}