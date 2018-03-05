package com.ibm.microempresa.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author kristian
 *
 */
@Entity
@Table(name="TBL_PRD_PRODUCTO")
public class Producto {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
		
	@Column(name = "PRD_NOMBRE", nullable = false, length = 250)
	private String nombre;

	@Column(name = "PRD_CANTIDAD", nullable = false, length = 3)
	private Integer cantidad;
	
	@Column(name = "PRD_VALOR", nullable = false, length = 6, precision = 4)
	private BigDecimal valor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="solicitud")
	private Solicitud solicitud;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	
}	