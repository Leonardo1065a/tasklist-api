package br.com.leonardo.silva.TaskList.business;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leonardo.silva.TaskList.model.Task;
import br.com.leonardo.silva.TaskList.model.resource.TaskResource;
import br.com.leonardo.silva.TaskList.repository.TaskRepository;

@Service
public class TaskBusiness {

	
	private TaskRepository repository; 
	
	@Autowired
	public TaskBusiness(TaskRepository repository) {
		this.repository = repository;
	}
	
	public List<TaskResource> get(){
		List<Task> listTask = this.repository.findAll();
		List<TaskResource> listResource = new ArrayList<>();
		if(listTask.size() > 0)
			listTask.stream().map(toResource)
							 .forEach((task) -> listResource.add(task));;
		return listResource;
	}
	
	Function<Task, TaskResource> toResource = task -> task.toResource();
	
	public TaskResource get(Long id){
		Task task = this.repository.findOne(id); 
		return task.getId() != null ? task.toResource() : null;
	}
	
	public TaskResource saveOrUpdate(Task task) throws Exception {
		try {
			this.handlerCreate(task);
			this.handlerEdit(task);
			this.handlerFinished(task);
			Task taskSave = this.repository.save(task);		
			return taskSave.toResource();
		} catch (Exception e) {
			throw new Exception("Erro ao salvar", e);
		}
	}
	
	public void handlerCreate(Task task){
		if(task.getId() == null)
			task.setDtCriacao(new java.util.Date());
	}
	
	public void handlerEdit(Task task){
		task.setDtEdicao(new java.util.Date());
	}
	
	public void handlerFinished(Task task){
		if(task.getTpStatus().equals(2L))
			task.setDtConclusao(new java.util.Date());
		else {
			task.setDtConclusao(null);
		}
	}
	
	public void delete(Long id) throws Exception {
		Task task = this.repository.findOne(id);
		if(task != null) {			
			this.repository.delete(id);
		}else {
			throw new Exception("Erro ao deletar");
		}
	}
}
