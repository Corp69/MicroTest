package com.mcroservice.api.responses;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;



@NamedNativeQuery(
    name = "CuentasAPagarResp.findCuentasPorPagar",
    query = "SELECT * FROM public.getCuentasPorPAGAR(:tasaInteres, :diasAnioComercial)",
    resultClass = CuentasAPagarResp.class
)

@Entity
public class CuentasAPagarResp {

	
	public CuentasAPagarResp() {
	
	}
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
	
	private Date fecha;
	private Integer  plazo;
	private Double amount;
	private Double interes;
	private Double iva;
	private Double pago;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getPlazo() {
		return plazo;
	}
	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getInteres() {
		return interes;
	}
	public void setInteres(Double interes) {
		this.interes = interes;
	}
	public Double getIva() {
		return iva;
	}
	public void setIva(Double iva) {
		this.iva = iva;
	}
	public Double getPago() {
		return pago;
	}
	public void setPago(Double pago) {
		this.pago = pago;
	}

    
	
	
	
}