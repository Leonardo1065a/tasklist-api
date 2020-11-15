package br.com.leonardo.silva.TaskList.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.leonardo.silva.TaskList.model.resource.TaskResource;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "task")
@Getter @Setter @NoArgsConstructor
@Accessors(chain = true)
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "NM_TASK", nullable = false)
	private String nmTask;;
	
	@Column(name = "TP_STATUS", nullable = false)
	private Long tpStatus;
	
	@Column(name = "DS_TASK")
	private String dsTask;
	
	@Column(name = "DT_CRIACAO")
	private Date dtCriacao;
	
	@Column(name = "DT_EDICAO")
	private Date dtEdicao;
	
	@Column(name = "DT_CONCLUSAO")
	private Date dtConclusao;
	
	@Column(name = "NR_POSITION")
	private Long nrPosition;
	
	public TaskResource toResource() {
		return new TaskResource()
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

