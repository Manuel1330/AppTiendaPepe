package com.example.apptiendapepe.Datos;

public class Articulos {

    private String codigoArt;
    private String descripcionArt;
    private Double precioArt;
    private Double stockageArt;
    private String fotoArt;

    public Articulos() {
    }

    public Articulos(String codigoArt, String descripcionArt, Double precioArt, Double stockageArt, String fotoArt) {
        this.codigoArt = codigoArt;
        this.descripcionArt = descripcionArt;
        this.precioArt = precioArt;
        this.stockageArt = stockageArt;
        this.fotoArt = fotoArt;
    }

    public String getCodigoArt() { return codigoArt; }
    public void setCodigoArt(String codigoArt) { this.codigoArt = codigoArt; }

    public String getDescripcionArt() { return descripcionArt; }
    public void setDescripcionArt(String descripcionArt) { this.descripcionArt = descripcionArt; }

    public Double getPrecioArt() { return precioArt; }
    public void setPrecioArt(Double precioArt) { this.precioArt = precioArt; }

    public Double getStockageArt() { return stockageArt; }
    public void setStockageArt(Double stockageArt) { this.stockageArt = stockageArt; }

    public String getFotoArt() { return fotoArt; }
    public void setFotoArt(String fotoArt) { this.fotoArt = fotoArt; }

}
