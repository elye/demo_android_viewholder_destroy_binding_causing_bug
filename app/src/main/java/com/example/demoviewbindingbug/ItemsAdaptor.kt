package com.example.demoviewbindingbug

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoviewbindingbug.databinding.ItemLayoutBinding

class ItemsAdaptor: RecyclerView.Adapter<ItemViewHolder>() {

    private val items = listOf(
        ItemModel("Tiger", R.drawable.tiger),
        ItemModel("Lion", R.drawable.lion),
        ItemModel("Elephant", R.drawable.elephant),
        ItemModel("Bear", R.drawable.bear),
        ItemModel("Kangaroo", R.drawable.kangaroo),
        ItemModel("Ox", R.drawable.ox),
        ItemModel("Panda", R.drawable.panda),
        ItemModel("Whale", R.drawable.whale),
        ItemModel("Octopus", R.drawable.optopus),
        ItemModel("Iguana", R.drawable.iguana),
        ItemModel("Zebra", R.drawable.zebra),
        ItemModel("Orang Utan", R.drawable.orangutan),
        ItemModel("Gorilla", R.drawable.gorilla),
        ItemModel("Eagle", R.drawable.eagle),
        ItemModel("Crocodile", R.drawable.crocodile),
        ItemModel("Hippopotamus", R.drawable.hippopotamus),
        ItemModel("Rhinoceros", R.drawable.rhinoceros),
        ItemModel("Penguin", R.drawable.penguin),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
