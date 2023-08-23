package com.todoapi.todomanger.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;


import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todoId;
    private String title;
    private String content;
    private Boolean status;
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
