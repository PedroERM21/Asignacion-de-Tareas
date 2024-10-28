package Controler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.aplicaciondegestiondetareas.R

class AddTaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)

        view.findViewById<Button>(R.id.saveTaskButton).setOnClickListener {
            val title = view.findViewById<EditText>(R.id.taskTitleInput).text.toString()
            val description = view.findViewById<EditText>(R.id.taskDescriptionInput).text.toString()

            if (title.isNotBlank() && description.isNotBlank()) {
                (activity as MainActivity).taskRepository.addTask(title, description)
                (activity as MainActivity).taskAdapter.notifyDataSetChanged()
                parentFragmentManager.popBackStack()
            } else {
                Toast.makeText(context, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}

