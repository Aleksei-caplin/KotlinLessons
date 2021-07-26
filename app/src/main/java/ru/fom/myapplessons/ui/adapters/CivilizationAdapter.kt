package ru.fom.myapplessons.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.civilization_item.view.*
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.data.remote.res.CivilizationDataRes

import ru.fom.myapplessons.data.remote.res.CivilizationList

class CivilizationAdapter(private val listener: (Civilization) -> Unit):RecyclerView.Adapter<CivilizationAdapter.CivilizationViewHolder>() {

    private var civList: List<Civilization> = listOf()

    inner class CivilizationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(civ: Civilization, listener: (Civilization) -> Unit) = with(itemView) {
            tv_civ_title.text = "Цивилизация: ${civ.name}"

            itemView.setOnClickListener {
                listener.invoke(civ)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CivilizationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.civilization_item, parent, false)
        return CivilizationViewHolder(view)
    }

    override fun onBindViewHolder(holder: CivilizationViewHolder, position: Int) {
        holder.bind(civList[position], listener)
    }

    override fun getItemCount(): Int = civList.size

    fun updateList(data: List<Civilization>) {
        civList = data
        notifyDataSetChanged()
    }
}