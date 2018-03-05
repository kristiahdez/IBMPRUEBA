package com.ibm.microempresa.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author kristian
 *
 */
@Entity
@Table(name="TBL_SLD_SOLICITUD")
@SequenceGenerator(name="SEQUENCIA_SOLICITUD", initialValue=1, allocationSize=100)
public class Solicitud {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA_SOLICITUD")
	private int id;
	
	@Column(name = "SLD_CLIENTE", nullable = false, length = 250)
	private String cliente;
	
	@Column(name = "SLD_TIPO_DOCUMENTO", nullable = false, length = 3)
	private String tipoDocumento;

	@Column(name = "SLD_NUMERO_DOCUMENTI", nullable = false, length = 12)
	private Integer numeroDocumento;
	
	@OneToMany(mappedBy="Solicitud" )
	private List<Producto> productos;
	
	@Column(name = "SLD_CANTIDAD_PRODCUTO", nullable = false, length = 12)
	private Integer cantidadProductos;
	
	@Column(name="SLD_FECHA_SOLICITUD" , nullable = false)
	private Date fechaSolicitud;
	
	@Column(name = "SLD_DIRECCION_ENTREGA", nullable = false, length = 250)
	private String direccionEntrega;
	
	@Column(name = "SLD_VALOR_PERDIDO", nullable = false, length = 12)
	private BigDecimal valorPedido;
	
	@Transient
	private String respuestaPeticion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public Integer getCantidadProductos() {
		return cantidadProductos;
	}
	public void setCantidadProductos(Integer cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public String getDireccionEntrega() {
		return direccionEntrega;
	}
	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	public BigDecimal getValorPedido() {
		return valorPedido;
	}
	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}
	public String getRespuestaPeticion() {
		return respuestaPeticion;
	}
	public void setRespuestaPeticion(String respuestaPeticion) {
		this.respuestaPeticion = respuestaPeticion;
	}
	
	
}	