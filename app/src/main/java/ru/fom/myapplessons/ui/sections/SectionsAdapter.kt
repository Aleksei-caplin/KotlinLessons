package ru.fom.myapplessons.ui.sections

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.section_item.view.*
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.Sections

class SectionsAdapter(var sectionList: List<Sections> = listOf(), val listener:(Sections) -> Unit):RecyclerView.Adapter<SectionsAdapter.SectionViewHolder>() {

    inner class SectionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(sectionItem: Sections, listener: (Sections) -> Unit) = with(itemView){
            section_title.text = sectionItem.name

            itemView.setOnClickListener {
                listener.invoke(sectionItem)
            }
        }
    }

    fun updateSectionList(data: List<Sections>) {
        sectionList = data
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val sectionView = LayoutInflater.from(parent.context).inflate(R.layout.section_item, parent, false)
        return SectionViewHolder(sectionView)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(sectionList[position], listener)
    }

    override fun getItemCount(): Int = sectionList.size
}