package com.augusto.taskflow.repository;

import com.augusto.taskflow.model.Task;
import com.augusto.taskflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.augusto.taskflow.model.TaskStatus;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByUser(User user);

}