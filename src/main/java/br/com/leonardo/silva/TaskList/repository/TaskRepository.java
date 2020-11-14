package br.com.leonardo.silva.TaskList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.leonardo.silva.TaskList.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
