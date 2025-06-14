package tv.purple.monolith.bridge

import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallback<T : Any>(
    private val oldList: List<T>,
    private val newList: List<T>,
    private val isSame: (T, T) -> Boolean = { old, new -> old == new },
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldList.getOrNull(oldItemPosition)
        val new = newList.getOrNull(newItemPosition)
        return when {
            old == null && new == null -> true
            old == null || new == null -> false
            else -> isSame(old, new)
        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldList.getOrNull(oldItemPosition)
        val new = newList.getOrNull(newItemPosition)
        return when {
            old == null && new == null -> true
            old == null || new == null -> false
            else -> isSame(old, new)
        }
    }
}
