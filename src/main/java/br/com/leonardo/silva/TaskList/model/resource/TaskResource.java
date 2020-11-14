package br.com.leonardo.silva.TaskList.model.resource;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.leonardo.silva.TaskList.model.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @NoArgsConstructor
@Accessors(chain = true)
public class TaskResource {
	
	private Long id;
	
	private String nmTask;;
	
	private Long tpStatus;
	
	private String dsTask;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dtCriacao;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dtEdicao;
	
	private Date dtConclusao;
	
	private Long nrPosition;
	
	public Task toEntity() {	
		return new Task()
				.setId(this.id)
				.setNmTask(this.nmTask)
				.setTpStatus(this.tpStatus)
				.setDsTask(this.dsTask)
				.setDtCriacao(this.dtCriacao)
				.setDtEdicao(this.dtEdicao)
				.setDtConclusao(this.dtConclusao)
				.setNrPosition(this.nrPosition);
	}

}
