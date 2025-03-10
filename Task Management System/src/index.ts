import { TaskManager } from "./services/TaskManager.js";

const taskManager = new TaskManager();

(document.getElementById("addTaskBtn") as HTMLButtonElement).addEventListener("click", () => {
    const title = (document.getElementById("taskTitle") as HTMLInputElement).value;
    const description = (document.getElementById("taskDesc") as HTMLInputElement).value;
    if (title && description) {
        taskManager.addTask(title, description);
        (document.getElementById("taskTitle") as HTMLInputElement).value = "";
        (document.getElementById("taskDesc") as HTMLInputElement).value = "";
    }
});

(window as any).markComplete = (id: number) => taskManager.markTaskComplete(id);