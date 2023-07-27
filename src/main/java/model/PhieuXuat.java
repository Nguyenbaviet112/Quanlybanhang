package model;

public class PhieuXuat {
    private int MaPx;
    private String NgayLap;
    private double SoTienMua;
    private int MaKH;
    private double SoTienTruocThanhToan;
    private double SoDuConLai;

    public int getMaKH() {
        return MaKH;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public double getSoDuConLai() {
        return SoDuConLai;
    }

    public double getSoTienMua() {
        return SoTienMua;
    }

    public double getSoTienTruocThanhToan() {
        return SoTienTruocThanhToan;
    }

    public int getMaPx() {
        return MaPx;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public void setNgayLap(String ngayLap) {
        NgayLap = ngayLap;
    }

    public void setMaPx(int maPx) {
        MaPx = maPx;
    }

    public void setSoDuConLai(double soDuConLai) {
        SoDuConLai = soDuConLai;
    }

    public void setSoTienMua(double soTienMua) {
        SoTienMua = soTienMua;
    }

    public void setSoTienTruocThanhToan(double soTienTruocThanhToan) {
        SoTienTruocThanhToan = soTienTruocThanhToan;
    }
}
