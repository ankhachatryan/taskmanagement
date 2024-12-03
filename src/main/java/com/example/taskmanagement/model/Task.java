package com.example.taskmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @PrimaryKey("task_id")
    private UUID taskId;

    @Column("user_id")
    @CassandraType(type = CassandraType.Name.TEXT)
    private UUID userId;
    private String title;
    private String description;
    private String status;
    private LocalDateTime createdAt;
}