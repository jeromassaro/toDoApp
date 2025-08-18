package tasks.toDoApp.dto;

import tasks.toDoApp.model.Task;

import java.util.List;

public class UserGetDTO {

    private String email;

    private List<Task> taskList;

    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
