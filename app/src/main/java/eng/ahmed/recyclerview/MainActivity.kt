package eng.ahmed.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import eng.ahmed.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(getLayoutInflater())
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var todoList = mutableListOf(
            Todo("finish kotlin ", true),
            Todo("finish recycler view", false),
            Todo("enable hibernate in pop os", false),
            Todo("do simple app in android ", false),
            Todo("do some problem solving using kotlin ", false),
            Todo("check some updates ", true),
            Todo("contact with the supervisor", false)
        )

        val adapter = TodoAdapter(todoList)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.btnAddTodo.setOnClickListener {
            val title = binding.etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)

            //adapter.notifyDataSetChanged()
            adapter.notifyItemInserted(todoList.size-1) //this more efficient  than the upper code since it dont update the whole recycler view and jus the given position
        }

    }
}