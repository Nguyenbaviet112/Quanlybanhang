package model;

public class KhuyenMai {
    private int MaKM;
    private String Code;
    private String TenKM;
    private String TGBD;
    private String TGKT;
    private double SoTienKM;

    public double getSoTienKM() {
        return SoTienKM;
    }

    public void setSoTienKM(double SoTienKM) {
        this.SoTienKM = SoTienKM;
    }
    
    

    public int getMaKM() {
        return MaKM;
    }

    public String getCode() {
        return Code;
    }

    public String getTenKM() {
        return TenKM;
    }

    public String getTGBD() {
        return TGBD;
    }

    public String getTGKT() {
        return TGKT;
    }

    public void setMaKM(int maKM) {
        MaKM = maKM;
    }

    public void setCode(String code) {
        Code = code;
    }

    public void setTenKM(String tenKM) {
        TenKM = tenKM;
    }

    public void setTGBD(String TGBD) {
        this.TGBD = TGBD;
    }

    public void setTGKT(String TGKT) {
        this.TGKT = TGKT;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" +
                "MaKM=" + MaKM +
                ", Code='" + Code + '\'' +
                ", TenKM='" + TenKM + '\'' +
                ", TGBD='" + TGBD + '\'' +
                ", TGKT='" + TGKT + '\'' +
                '}';
    }
}
