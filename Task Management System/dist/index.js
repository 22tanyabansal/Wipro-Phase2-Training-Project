import { TaskManager } from "./services/TaskManager.js";
const taskManager = new TaskManager();
document.getElementById("addTaskBtn").addEventListener("click", () => {
    const title = document.getElementById("taskTitle").value;
    const description = document.getElementById("taskDesc").value;
    if (title && description) {
        taskManager.addTask(title, description);
        document.getElementById("taskTitle").value = "";
        document.getElementById("taskDesc").value = "";
    }
});
window.markComplete = (id) => taskManager.markTaskComplete(id);
