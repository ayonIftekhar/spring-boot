package com.SpringBootTutorial.TodoApp.Todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


@Entity
public class Todo {

    @Id
    @GeneratedValue
    private int serialNo;
    private String userName;
    @Size(min=10,message="Enter at least 10 chars")
    private String description ;
    private LocalDate target;
    private boolean isDone;

    //constructor , getter , setter

    public Todo(){

    }

    public Todo(int serialNo, String userName, String description, LocalDate target, boolean isDone) {
        this.serialNo = serialNo;
        this.userName = userName;
        this.description = description;
        this.target = target;
        this.isDone = isDone;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public String getUserName() {
        return userName;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTarget() {
        return target;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTarget(LocalDate target) {
        this.target = target;
    }

    public void setIsDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "serialNo=" + serialNo +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", target=" + target +
                ", isDone=" + isDone +
                '}';
    }
}
