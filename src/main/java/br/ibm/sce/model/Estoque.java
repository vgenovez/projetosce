package br.ibm.sce.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TB_ESTOQUE")
public class Estoque implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "estoque_id")
	private long id;
	
	@NotNull
	@Column(unique = true)
	private String assettag;
	
	@NotNull
	private String hostname;
	
	@NotNull
	private String modelo;
	
	@Column(unique = true)
	@NotNull
	private String serie;
	
	@NotNull
	private String tipo;
	
	@NotNull
	private String fabri;
	
	@NotNull
	private String propri;
	
	@NotNull
	private String local;
	
	@NotNull
	private String usuario;
	
	@NotNull
	private String login;
	
	@NotNull
	private String nfiscal;
	
	@NotNull
	private String stdoativo;
	
	@NotNull
	private String tecresp;
	
	@NotNull
	private String posdoativo;
	
	@NotNull
	private String tecatman;
	
	@NotNull
	private String cham;
	
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
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAssettag() {
		return assettag;
	}

	public void setAssettag(String assettag) {
		this.assettag = assettag;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFabri() {
		return fabri;
	}

	public void setFabri(String fabri) {
		this.fabri = fabri;
	}

	public String getPropri() {
		return propri;
	}

	public void setPropri(String propri) {
		this.propri = propri;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNfiscal() {
		return nfiscal;
	}

	public void setNfiscal(String nfiscal) {
		this.nfiscal = nfiscal;
	}

	public String getStdoativo() {
		return stdoativo;
	}

	public void setStdoativo(String stdoativo) {
		this.stdoativo = stdoativo;
	}

	public String getTecresp() {
		return tecresp;
	}

	public void setTecresp(String tecresp) {
		this.tecresp = tecresp;
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

	public String getPosdoativo() {
		return posdoativo;
	}

	public void setPosdoativo(String posdoativo) {
		this.posdoativo = posdoativo;
	}

	public String getTecatman() {
		return tecatman;
	}

	public void setTecatman(String tecatman) {
		this.tecatman = tecatman;
	}

	public String getCham() {
		return cham;
	}

	public void setCham(String cham) {
		this.cham = cham;
	}

}
