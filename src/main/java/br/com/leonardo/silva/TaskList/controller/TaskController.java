package br.com.leonardo.silva.TaskList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leonardo.silva.TaskList.business.TaskBusiness;
import br.com.leonardo.silva.TaskList.model.resource.TaskResource;

@CrossOrigin
@RestController
@RequestMapping("tasks")
public class TaskController {
	
	private @Autowired TaskBusiness business;

	@GetMapping
	public ResponseEntity<List<TaskResource>> get() {
		return ResponseEntity.ok(this.business.get());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<TaskResource> get(@PathVariable("id") Long id) {
		TaskResource task = this.business.get(id);
		return task != null ? ResponseEntity.ok(task) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping
	public ResponseEntity<TaskResource> post(@RequestBody TaskResource task) throws Exception {
		Boolean isSave = task.getId() != null ? true : false; 
		TaskResource taskSaved = this.business.saveOrUpdate(task.toEntity());
		return isSave ? ResponseEntity.status(HttpStatus.OK).body(taskSaved) : 
			ResponseEntity.status(HttpStatus.CREATED).body(taskSaved);
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<TaskResource> put(@PathVariable("id") Long id, @RequestBody TaskResource task) throws Exception {
		task.setId(id);
		return this.post(task);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
		this.business.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
