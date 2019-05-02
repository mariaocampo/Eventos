package co.com.ibm.eventos.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="evento")
public class Evento {

	@Column(name="id")
	private int id;
	
	@Column(name="servidor")
	private String Servidor;
	
	@Column(name="detalleServidor")
	private String detalleServidor;
	
	@Column(name="fechaAlerta")
	private Date fechaAlerta;
	
	@Column(name="categorizacion")
	private String categorizacion;
	
	@Column(name="variableAlertada")
	private String variableAlertada;
	
	@Column(name="detalleVariableAlertada")
	private String detalleVariableAlertada;
	
	@Column(name="prioridad")
	private String prioridad;
	
	@Column(name="plataforma")
	private String plataforma;
	
	@Column(name="responsable")
	private String responsable;
	
	@Column(name="mes")
	private String mes;
	
	@Column(name="escalamiento")
	private String escalamiento;
	
	//LINEA BASE
}
