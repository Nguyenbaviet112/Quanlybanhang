package model;

public class QuyCach {
    private int MaQC;
    private int soluong;
    private double giatien;
    private int MaSP;

    public int getMaSP() {
        return MaSP;
    }

    public double getGiatien() {
        return giatien;
    }

    public int getMaQC() {
        return MaQC;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public void setGiatien(double giatien) {
        this.giatien = giatien;
    }

    public void setMaQC(int maQC) {
        MaQC = maQC;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

}
