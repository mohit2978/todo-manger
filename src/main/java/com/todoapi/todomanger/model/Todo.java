package com.todoapi.todomanger.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private int todoId;
    private String title;
    private String content;
    private String status;
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date todoDate;
    private Date creationDate;

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", todoDate=" + todoDate +
                ", creationDate=" + creationDate +
                '}';
    }
}
