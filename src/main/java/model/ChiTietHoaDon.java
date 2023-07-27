package model;

public class ChiTietHoaDon {
    private int MaCTHD;
    private String TenKhachHang;
    private String TenSanPham;
    private int SoLuong;
    private double GiaGoc;
    private String KhuyenMai;
    private double GiaCuoi;
    private String NgayLap;
    private int MaHD;
    private int MaKH;
    private int MaSP;

    public String getNgayLap() {
        return NgayLap;
    }

    public int getMaKH() {
        return MaKH;
    }

    public int getMaSP() {
        return MaSP;
    }

    public String getKhuyenMai() {
        return KhuyenMai;
    }

    public int getMaHD() {
        return MaHD;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public double getGiaCuoi() {
        return GiaCuoi;
    }

    public double getGiaGoc() {
        return GiaGoc;
    }

    public int getMaCTHD() {
        return MaCTHD;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setKhuyenMai(String khuyenMai) {
        KhuyenMai = khuyenMai;
    }

    public void setGiaGoc(double giaGoc) {
        GiaGoc = giaGoc;
    }

    public void setNgayLap(String ngayLap) {
        NgayLap = ngayLap;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public void setMaHD(int maHD) {
        MaHD = maHD;
    }

    public void setGiaCuoi(double giaCuoi) {
        GiaCuoi = giaCuoi;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public void setMaCTHD(int maCTHD) {
        MaCTHD = maCTHD;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public void setTenKhachHang(String tenKhachHang) {
        TenKhachHang = tenKhachHang;
    }
}
