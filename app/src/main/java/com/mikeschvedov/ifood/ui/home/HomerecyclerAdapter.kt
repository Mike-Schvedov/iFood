package com.mikeschvedov.ifood.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mikeschvedov.ifood.R
import com.mikeschvedov.ifood.data.local_data.database.entities.FoodEntry
import javax.inject.Inject


class HomeRecyclerAdapter @Inject constructor(private val listener: IsListEmptyListener) :
    RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {

    var list: MutableList<FoodEntry> = mutableListOf()

    fun interface IsListEmptyListener{
        fun onDataReady(
            isEmpty: Boolean
        )
    }

    // add new data
    fun setNewData(newData: List<FoodEntry>) {
        // We send a callback to let the fragment know that
        // the list is empty, and we can show the "nothing to show" textview
        if(newData.isNullOrEmpty()){
            println("is empty")
            listener.onDataReady(true)
        }else{
            listener.onDataReady(false)

        }
        // passing the new and old list into the callback
        val diffCallback = DiffUtilCallbackShips(list, newData)
        // we get the result
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        // we clear the old list
        list.clear()
        // and replace it with the new list
        list.addAll(newData)
        diffResult.dispatchUpdatesTo(this)
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView =
            itemView.findViewById(R.id.entry_name_xml)
        var calories: TextView =
            itemView.findViewById(R.id.entry_calories_xml)
        var image: ShapeableImageView =
            itemView.findViewById(R.id.entry_image_xml)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recyclerview_item,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        val item = list[position]

        // --- Setting the name --- //
        holder.name.text = item.foodName

        // --- Setting the calories --- //
        holder.calories.text = item.calories.toString()

        // --- Setting the image --- //
        holder.image.setImageResource(item.image)


        //TODO add option to delete expense if clicked on, with alert of course
        // -- Sending the clicked item as callback -- //
//            holder.itemLayout.setOnClickListener {
//                listener.onItemClicked(item)

//            }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class DiffUtilCallbackShips(
    private val oldList: List<FoodEntry>,
    private val newList: List<FoodEntry>
) :
    DiffUtil.Callback() {

    // old size
    override fun getOldListSize(): Int = oldList.size

    // new list size
    override fun getNewListSize(): Int = newList.size

    // if items are same
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.foodId == newItem.foodId
    }

    // check if contents are same
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return oldItem == newItem
    }
}