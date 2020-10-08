package ru.fom.myapplessons.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.civilization_list_item.view.*
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.Civilization

class CivilizationAdapter(private val listener:(Civilization) -> Unit ): RecyclerView.Adapter<CivilizationAdapter.CivilizationViewHolder>() {

    private var civilizationList: List<Civilization> = listOf()

    inner class CivilizationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(civilizationItem: Civilization, listener: (Civilization) -> Unit) = with(itemView) {
            tv_civilization_name.text = civilizationItem.name
            tv_civilization_expansion.text = civilizationItem.expansion
            tv_civilization_army_type.text = civilizationItem.army_type

            itemView.setOnClickListener {
                listener.invoke(civilizationItem)
            }
        }
    }

    fun updateList(data: List<Civilization>) {
        civilizationList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CivilizationViewHolder {
        val civilizationView = LayoutInflater.from(parent.context).inflate(R.layout.civilization_list_item ,parent, false)
        return CivilizationViewHolder(civilizationView)
    }

    override fun onBindViewHolder(holder: CivilizationViewHolder, position: Int) {
        holder.bind(civilizationList[position], listener)
    }

    override fun getItemCount(): Int = civilizationList.size

}