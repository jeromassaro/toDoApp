package tasks.toDoApp.dto;

import tasks.toDoApp.model.Task;

import java.util.List;

public class UserGetDTO {

    private String username;

    private List<Task> taskList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
