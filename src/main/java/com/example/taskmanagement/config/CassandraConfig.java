package com.example.taskmanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.lang.NonNull;

@Configuration
@EnableCassandraRepositories(basePackages = "com.example.taskmanagement.repository")
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    @NonNull
    protected String getKeyspaceName() {
        return "task_management";
    }
}