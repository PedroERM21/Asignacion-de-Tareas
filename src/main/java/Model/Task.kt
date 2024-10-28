package Model

data class Task(
    val id: Int,
    val title: String,
    var description: String,
    var completed: Boolean = false
)
