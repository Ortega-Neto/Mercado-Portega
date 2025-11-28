package br.com.lconeto.mercadoportega.shopping.domain

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.lconeto.mercadoportega.common.data.ShoppingItem
import br.com.lconeto.mercadoportega.databinding.ListItemShoppingBinding

typealias OnItemClicked = (ShoppingItem) -> Unit

class ShoppingAdapter(
    private var items: List<ShoppingItem>,
    private val onItemClicked: OnItemClicked
) : RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>() {

    fun updateList(newItems: List<ShoppingItem>) {
        val diffCallback = ShoppingItemDiffCallback(this.items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.items = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val binding = ListItemShoppingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ShoppingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class ShoppingViewHolder(private val binding: ListItemShoppingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ShoppingItem) {
            binding.itemNameTextView.text = item.name
            binding.itemCategoryTextView.text = item.category.name

            if (item.isChecked) {
                binding.itemNameTextView.paintFlags = binding.itemNameTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                binding.itemNameTextView.alpha = 0.5f
                binding.itemCategoryTextView.alpha = 0.5f
            } else {
                binding.itemNameTextView.paintFlags = binding.itemNameTextView.paintFlags and
                    Paint.STRIKE_THRU_TEXT_FLAG.inv()
                binding.itemNameTextView.alpha = 1.0f
                binding.itemCategoryTextView.alpha = 1.0f
            }

            binding.root.setOnClickListener {
                onItemClicked(item)
            }
        }
    }
}

class ShoppingItemDiffCallback(
    private val oldList: List<ShoppingItem>,
    private val newList: List<ShoppingItem>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name &&
            oldList[oldItemPosition].category == newList[newItemPosition].category
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
