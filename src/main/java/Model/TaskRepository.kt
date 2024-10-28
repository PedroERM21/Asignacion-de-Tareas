package Model

class TaskRepository {
    private val tasks = mutableListOf<Task>()
    private var idCounter = 0

    fun addTask(title: String, description: String): Task {
        val newTask = Task(idCounter++, title, description)
        tasks.add(newTask)
        return newTask
    }

    fun getTasks(): List<Task> = tasks

    fun completeTask(taskId: Int) {
        tasks.find { it.id == taskId }?.completed = true
    }

    fun deleteTask(taskId: Int) {
        tasks.removeAll { it.id == taskId }
    }
}
