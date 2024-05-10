package com.example.projet_info

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class BorrowedItemsAdapter(private val items: List<Any>, private val onReturnClicked: (Any) -> Unit) :
    RecyclerView.Adapter<BorrowedItemsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewItemName: TextView = view.findViewById(R.id.textViewItemName)
        val buttonReturn: Button = view.findViewById(R.id.buttonReturn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_borrowed, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        when (item) {
            is Book -> {
                holder.textViewItemName.text = "Book: ${item.title} by ${item.author}"
            }
            is Game -> {
                holder.textViewItemName.text = "Game: ${item.name}"
            }
        }
        holder.buttonReturn.setOnClickListener {
            onReturnClicked(item)
        }
    }

    override fun getItemCount() = items.size
}