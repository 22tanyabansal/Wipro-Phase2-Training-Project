import { Task } from "../models/Task.js";

export class TaskManager {
    private tasks: Task[] = [];
    private taskIdCounter: number = 1;

    addTask(title: string, description: string): void {
        const newTask = new Task(this.taskIdCounter++, title, description);
        this.tasks.push(newTask);
        this.renderTasks();
    }

    getTasks(): Task[] {
        return this.tasks;
    }

    markTaskComplete(id: number): void {
        const task = this.tasks.find(task => task.id === id);
        if (task) {
            task.completed = true;
            this.renderTasks();
        }
    }

    renderTasks(): void {
        const taskList = document.getElementById("taskList");
        if (!taskList) return;
        taskList.innerHTML = "";

        this.tasks.forEach(task => {
            const taskItem = document.createElement("li");
            taskItem.className = `list-group-item ${task.completed ? 'list-group-item-success' : ''}`;
            taskItem.innerHTML = `
                <strong>${task.title}</strong> - ${task.description}
                <button class="btn btn-sm btn-primary float-end" onclick="markComplete(${task.id})">✔</button>
            `;
            taskList.appendChild(taskItem);
        });
    }
}