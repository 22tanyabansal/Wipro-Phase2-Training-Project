import { Task } from "../models/Task.js";
export class TaskManager {
    constructor() {
        this.tasks = [];
        this.taskIdCounter = 1;
    }
    addTask(title, description) {
        const newTask = new Task(this.taskIdCounter++, title, description);
        this.tasks.push(newTask);
        this.renderTasks();
    }
    getTasks() {
        return this.tasks;
    }
    markTaskComplete(id) {
        const task = this.tasks.find(task => task.id === id);
        if (task) {
            task.completed = true;
            this.renderTasks();
        }
    }
    renderTasks() {
        const taskList = document.getElementById("taskList");
        if (!taskList)
            return;
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
