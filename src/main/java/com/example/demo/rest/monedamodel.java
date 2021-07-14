package com.example.demo.rest;


public class monedamodel {

	protected int id;
    protected int moneda;
    protected String fecha;
    protected double venta;
    protected double compra;
    
    

	public monedamodel(int id, int moneda, String fecha, double venta, double compra) {
		super();
		this.id = id;
		this.moneda = moneda;
		this.fecha = fecha;
		this.venta = venta;
		this.compra = compra;
	}

	/**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad moneda.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad moneda.
     * 
     */
    public int getMoneda() {
        return moneda;
    }

    /**
     * Define el valor de la propiedad moneda.
     * 
     */
    public void setMoneda(int value) {
        this.moneda = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad venta.
     * 
     */
    public double getVenta() {
        return venta;
    }

    /**
     * Define el valor de la propiedad venta.
     * 
     */
    public void setVenta(double value) {
        this.venta = value;
    }

    /**
     * Obtiene el valor de la propiedad compra.
     * 
     */
    public double getCompra() {
        return compra;
    }

    /**
     * Define el valor de la propiedad compra.
     * 
     */
    public void setCompra(double value) {
        this.compra = value;
    }

}

