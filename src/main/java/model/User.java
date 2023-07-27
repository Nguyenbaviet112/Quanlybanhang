/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ThinkKING
 */
public class User {
    private  int maac;
    private String tendangnhap;
    private String matkhau;
    private String tenhienthi;
    private int bixoa;
    private int maloaitaikhoan;
    public int getBixoa() {
        return bixoa;
    }

    public void setBixoa(int bixoa) {
        this.bixoa = bixoa;
    }
    

    public User() {
    }
    
    public User(int maac, String tendangnhap, String matkhau, String tenhienthi, int bixoa, int maloaitaikhoan) {
        this.maac = maac;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.tenhienthi = tenhienthi;
        this.bixoa = bixoa;
        this.maloaitaikhoan = maloaitaikhoan;
    }
    


    public User(int maac, String tendangnhap, String matkhau, String tenhienthi, int maloaitaikhoan) {
        this.maac = maac;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.tenhienthi = tenhienthi;
        this.maloaitaikhoan = maloaitaikhoan;
    }

    public int getMaAC() {
        return maac;
    }

    public void setMaAC(int maac) {
        this.maac = maac;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public int getMaloaitaikhoan() {
        return maloaitaikhoan;
    }

    public User(String tendangnhap, String matkhau, String tenhienthi, int maloaitaikhoan) {
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.tenhienthi = tenhienthi;
        this.maloaitaikhoan = maloaitaikhoan;
    }

    public void setMaloaitaikhoan(int maloaitaikhoan) {
        this.maloaitaikhoan = maloaitaikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getTenhienthi() {
        return tenhienthi;
    }

    public void setTenhienthi(String tenhienthi) {
        this.tenhienthi = tenhienthi;
    }



    
    
    
}
