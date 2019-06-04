package com.example.listaproductos;

public class Producto {
    private String nombreProduct;
    private String fecha;
    private String precioProduct;
    private String statusProduct;
    private int imgEdit, imgDelete, imgLock;

    public Producto(String nombreProduct, String precioProduct, String fecha, String statusProduct){
        this.nombreProduct = nombreProduct;
        this.precioProduct = precioProduct;
        this.fecha = fecha;
        this.statusProduct = statusProduct;
        this.imgEdit = imgEdit;
        this.imgDelete = imgDelete;
        this.imgLock = imgLock;
    }

    public int getImgEdit() {
        return imgEdit;
    }

    public void setImgEdit(int imgEdit) {
        this.imgEdit = imgEdit;
    }

    public int getImgDelete() {
        return imgDelete;
    }

    public void setImgDelete(int imgDelete) {
        this.imgDelete = imgDelete;
    }

    public int getImgLock() {
        return imgLock;
    }

    public void setImgLock(int imgLock) {
        this.imgLock = imgLock;
    }

    public void setNombreProduct(String nombreProduct) {
        this.nombreProduct = nombreProduct;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setPrecioProduct(String precioProduct) {
        this.precioProduct = precioProduct;
    }

    public String getPrecioProduct() {
        return precioProduct;
    }

    public String getNombreProduct() {
        return nombreProduct;
    }

    public String getFecha() {
        return fecha;
    }

    public String getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(String statusProduct) {
        this.statusProduct = statusProduct;
    }
}
