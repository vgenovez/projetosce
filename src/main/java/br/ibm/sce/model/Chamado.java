package br.ibm.sce.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TB_CHAMADO")
public class Chamado {

	@Id
	private String chamados;
	
	private String nometec;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dtcad;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dtupt;
	
	@PrePersist
	private void onDtcad() {
		setDtcad(new Date());
	}
	
	@PreUpdate
	private void onDtupt() {
		setDtupt(new Date());
	}
	
	@ManyToOne
	private Estoque estoque;
	
	//Getter and Setters
	
	public String getChamados() {
		return chamados;
	}

	public void setChamados(String chamados) {
		this.chamados = chamados;
	}
	
	public String getNometec() {
		return nometec;
	}

	public void setNometec(String nometec) {
		this.nometec = nometec;
	}

	public Date getDtcad() {
		return dtcad;
	}

	public void setDtcad(Date dtcad) {
		this.dtcad = dtcad;
	}

	public Date getDtupt() {
		return dtupt;
	}

	public void setDtupt(Date dtupt) {
		this.dtupt = dtupt;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
}
