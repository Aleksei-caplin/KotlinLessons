package ru.fom.myapplessons.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.structure_item.view.*
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.Structure

class StructureAdapter(val listener: (Structure) -> Unit): RecyclerView.Adapter<StructureAdapter.StructureHolder>() {

    var structureLIst: List<Structure> = listOf()

    inner class StructureHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(structureHolder: Structure, listener: (Structure) -> Unit) = with(itemView) {

            tv_structure_name.text = structureHolder.name
            tv_structure_description.text = structureHolder.description
            tv_structure_expansion.text = structureHolder.expansion

            itemView.setOnClickListener {
                listener.invoke(structureHolder)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StructureHolder {
        val structureHolder = LayoutInflater.from(parent.context).inflate(R.layout.structure_item, parent, false)
        return StructureHolder(structureHolder)
    }

    override fun onBindViewHolder(holder: StructureHolder, position: Int) {
        holder.bind(structureLIst[position], listener)
    }

    override fun getItemCount(): Int = structureLIst.size

    fun updateList(data: List<Structure>) {
        structureLIst = data
        notifyDataSetChanged()
    }
}