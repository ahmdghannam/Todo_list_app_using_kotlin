package eng.ahmed.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eng.ahmed.recyclerview.databinding.ItemTodoBinding

class TodoAdapter(var todos: List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    // the view holder is the card that recycles
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(layoutInflater, parent, false)
        return TodoViewHolder(binding)
    }
    // to code what happened when new card is reached "requested"
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        holder.binding.tvTitle.text = todos[position].title
        holder.binding.cbDone.isChecked = todos[position].isChecked

    }

    override fun getItemCount(): Int {
        return todos.size
    };


}