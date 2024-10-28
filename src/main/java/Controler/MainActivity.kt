package Controler

import Model.TaskRepository
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicaciondegestiondetareas.R

class MainActivity : AppCompatActivity() {
    lateinit var taskRepository: TaskRepository
    lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskRepository = TaskRepository()
        taskAdapter = TaskAdapter(taskRepository.getTasks(), this::onTaskCompleted, this::onTaskDeleted)

        val recyclerView = findViewById<RecyclerView>(R.id.taskRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = taskAdapter

        findViewById<Button>(R.id.addTaskButton).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, AddTaskFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun onTaskCompleted(taskId: Int) {
        taskRepository.completeTask(taskId)
        taskAdapter.notifyDataSetChanged()
    }

    private fun onTaskDeleted(taskId: Int) {
        taskRepository.deleteTask(taskId)
        taskAdapter.notifyDataSetChanged()
    }
}


