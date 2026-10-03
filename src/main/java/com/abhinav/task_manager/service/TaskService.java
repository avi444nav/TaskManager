package com.abhinav.task_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhinav.task_manager.exception.ResourceNotFoundException;
import com.abhinav.task_manager.model.Task;
import com.abhinav.task_manager.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());
        return taskRepository.save(existingTask);
    }
    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }
    public List<Task> getTasksByCompletionStatus(boolean completed) {
        return taskRepository.findByCompleted(completed);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}