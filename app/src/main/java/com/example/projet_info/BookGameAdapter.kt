package com.example.projet_info

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView


interface OnItemBorrowedListener {
    fun onItemBorrowed(item: Any)
}

class BookGameAdapter(private val items: List<Any>, private val listener: OnItemBorrowedListener, private val username: String) : RecyclerView.Adapter<BookGameAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text_view_item)
        val borrowButton: Button = itemView.findViewById(R.id.buttonBorrow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        when (item) {
            is Book -> {
                holder.textView.text =
                    "Book: ${item.title} by ${item.author}, Available: ${item.availability}"
                holder.borrowButton.text = if (item.availability) "Borrow" else "Unavailable"
                holder.borrowButton.isEnabled = item.availability

                holder.borrowButton.setOnClickListener {
                    if (item.borrow(username, "Book")) {
                        notifyItemChanged(position)
                        listener.onItemBorrowed(item)
                    }
                }
            }
            is Game -> {
                holder.textView.text = "Game: ${item.name}, Available: ${item.availability}"
                holder.borrowButton.text = if (item.availability) "Borrow" else "Unavailable"
                holder.borrowButton.isEnabled = item.availability

                holder.borrowButton.setOnClickListener {
                    if (item.borrow(username, "Game")) {
                        notifyItemChanged(position)
                        listener.onItemBorrowed(item)
                }
            }

        }

    }}

    override fun getItemCount() = items.size

}