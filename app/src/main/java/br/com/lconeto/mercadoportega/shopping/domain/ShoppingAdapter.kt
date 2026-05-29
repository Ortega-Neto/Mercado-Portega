package br.com.lconeto.mercadoportega.shopping.domain

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.lconeto.mercadoportega.R
import br.com.lconeto.mercadoportega.common.data.ShoppingItem
import br.com.lconeto.mercadoportega.databinding.ListItemShoppingBinding

typealias OnItemClicked = (ShoppingItem) -> Unit

class ShoppingAdapter(
    private var items: List<ShoppingItem>,
    private val mode: AdapterMode = AdapterMode.SHOPPING,
    private val onItemClicked: OnItemClicked
) : RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>() {

    enum class AdapterMode {
        SHOPPING,
        SELECTION
    }

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

            when (mode) {
                AdapterMode.SHOPPING -> bindShoppingMode(item)
                AdapterMode.SELECTION -> bindSelectionMode(item)
            }

            binding.root.setOnClickListener {
                onItemClicked(item)
            }
        }

        private fun bindShoppingMode(item: ShoppingItem) {
            binding.itemCheckBox.visibility = View.GONE
            binding.itemContainer.setBackgroundColor(
                ContextCompat.getColor(binding.root.context, android.R.color.transparent)
            )

            if (item.isChecked) {
                binding.itemNameTextView.paintFlags =
                    binding.itemNameTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                binding.itemNameTextView.alpha = HALF_ALPHA
                binding.itemCategoryTextView.alpha = HALF_ALPHA
            } else {
                binding.itemNameTextView.paintFlags =
                    binding.itemNameTextView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                binding.itemNameTextView.alpha = FULL_ALPHA
                binding.itemCategoryTextView.alpha = FULL_ALPHA
            }
        }

        private fun bindSelectionMode(item: ShoppingItem) {
            binding.itemCheckBox.visibility = View.VISIBLE
            binding.itemCheckBox.isChecked = item.isChecked

            binding.itemNameTextView.paintFlags =
                binding.itemNameTextView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            binding.itemNameTextView.alpha = FULL_ALPHA
            binding.itemCategoryTextView.alpha = FULL_ALPHA

            val backgroundColor = if (item.isChecked) {
                ContextCompat.getColor(binding.root.context, R.color.selection_highlight)
            } else {
                ContextCompat.getColor(binding.root.context, android.R.color.transparent)
            }
            binding.itemContainer.setBackgroundColor(backgroundColor)
        }
    }

    companion object {
        private const val FULL_ALPHA = 1.0f
        private const val HALF_ALPHA = 0.5f
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
