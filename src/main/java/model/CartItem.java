/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NguyenBaViet
 */
public class CartItem {
    private String MaSanPham;

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }
    private String HinhURL;
    private String TenSanPham;
    private double GiaSanPham;
    private int SoLuongMua;

    public String getHinhURL() {
        return HinhURL;
    }

    public void setHinhURL(String HinhURL) {
        this.HinhURL = HinhURL;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public double getGiaSanPham() {
        return GiaSanPham;
    }

    public void setGiaSanPham(double GiaSanPham) {
        this.GiaSanPham = GiaSanPham;
    }

    public int getSoLuongMua() {
        return SoLuongMua;
    }

    public void setSoLuongMua(int SoLuongMua) {
        this.SoLuongMua = SoLuongMua;
    }
    
    
    
    
}
