package com.mcroservice.api.req;

public class CuentasVO {
	
	private Double 	tasaInteres; // Usando BigDecimal para tasa de interés
	private Integer diasComercial;
	
	
	public Double getTasaInteres() {
		return tasaInteres;
	}
	public void setTasaInteres(Double tasaInteres) {
		this.tasaInteres = tasaInteres;
	}
	public Integer getDiasComercial() {
		return diasComercial;
	}
	public void setDiasComercial(Integer diasComercial) {
		this.diasComercial = diasComercial;
	}
	
	
	
    
}
