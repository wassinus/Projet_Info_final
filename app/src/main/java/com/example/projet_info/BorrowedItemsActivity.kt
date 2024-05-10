import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import com.example.projet_info.Book
import com.example.projet_info.Game
import com.example.projet_info.BorrowedItemsAdapter
import com.example.projet_info.Database
import com.example.projet_info.R

class BorrowedItemsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BorrowedItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrowed_items)

        Log.d("BorrowedItemsActivity", "Activity started") // Debug log

        recyclerView = findViewById(R.id.recyclerViewBorrowedItems)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Assume this fetches borrowed items, you'll replace this with your actual data fetching logic.
        val borrowedItems = getBorrowedItems()  // Fetch only borrowed items
        adapter = BorrowedItemsAdapter(borrowedItems, this::handleReturnItem)
        recyclerView.adapter = adapter

        adapter = BorrowedItemsAdapter(borrowedItems) { item ->
            handleReturnItem(item)
        }
        recyclerView.adapter = adapter
    }

    private fun getBorrowedItems(): List<Any> {
        return Database.getBorrowedItems()
    }

    private fun handleReturnItem(item: Any) {
        when (item) {
            is Book -> item.returnItem()
            is Game -> item.returnItem()
        }
        adapter.notifyDataSetChanged()  // Update the list after an item is returned
    }
}
