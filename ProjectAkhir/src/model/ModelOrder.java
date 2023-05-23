/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class ModelOrder {
    private Integer id;
    private String tujuan;
    private String nama;
    private String nohp;
    private Integer harga;
    private String jam;
    
    public void setId_order(Integer id_order) {
        this.id = id;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void setNoHp(String nohp){
        this.nohp = nohp;
    }
    
    public void setTujuan(String tujuan){
        this.tujuan = tujuan;
    }
    
    public void setHarga(Integer harga){
        this.harga = harga;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }
    
    public Integer getId_order() {
        return id;    
    }
    
    public String getJam() {
        return jam;
    }
    
    public String getTujuan() {
        return tujuan;
    }
    public Integer getHarga() {
        return harga;
    }
    public String getNama() {
        return nama;
    }
    public String getNoHp() {
        return nohp;
    }
}


