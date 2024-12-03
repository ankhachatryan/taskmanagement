package com.example.taskmanagement.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.stereotype.Component;

@Component
public class CassandraInitializer {

    private final CqlSession session;

    public CassandraInitializer(CqlSession session) {
        this.session = session;
        initializeDatabase();
    }

    public void initializeDatabase() {
        session.execute(
                "CREATE KEYSPACE IF NOT EXISTS task_management " +
                        "WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};"
        );

        session.execute(
                "CREATE TABLE IF NOT EXISTS users (" +
                        "user_id UUID PRIMARY KEY, " +
                        "username TEXT, " +
                        "email TEXT" +
                        ");"
        );

        session.execute(
                "CREATE TABLE IF NOT EXISTS tasks (" +
                        "task_id UUID PRIMARY KEY, " +
                        "user_id UUID, " +
                        "title TEXT, " +
                        "description TEXT, " +
                        "status TEXT, " +
                        "created_at TIMESTAMP" +
                        ");"
        );


/*  The following lines are for adding mock data to tables for testing and demo purposes.
    No need to keep them in the code after 1st execution.
        session.execute(
                "INSERT INTO users (user_id, username, email) VALUES (" +
                        UUID.randomUUID() + ", 'johndoe', 'johndoe@example.com');"
        );

        session.execute(
                "INSERT INTO users (user_id, username, email) VALUES (" +
                        UUID.randomUUID() + ", 'janedoe', 'janedoe@example.com');"
        );

        UUID userId1 = UUID.randomUUID();
        UUID userId2 = UUID.randomUUID();

        session.execute(
                "INSERT INTO tasks (task_id, user_id, title, description, status, created_at) VALUES (" +
                        UUID.randomUUID() + ", " + userId1 + ", 'Task 1', 'Description of Task 1', 'Pending', toTimestamp(now()));"
        );

        session.execute(
                "INSERT INTO tasks (task_id, user_id, title, description, status, created_at) VALUES (" +
                        UUID.randomUUID() + ", " + userId2 + ", 'Task 2', 'Description of Task 2', 'Completed', toTimestamp(now()));"
        );

        session.execute(
                "INSERT INTO tasks (task_id, user_id, title, description, status, created_at) VALUES (" +
                        UUID.randomUUID() + ", " + userId1 + ", 'Task 3', 'Description of Task 3', 'In Progress', toTimestamp(now()));"
        );

        session.execute("TRUNCATE tasks;");

        session.execute("TRUNCATE users;");
 */
    }
}