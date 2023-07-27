package model;

public class Trang {
    private String SoTrang;
    private String Status;

    public String getSoTrang() {
        return SoTrang;
    }

    public String getStatus() {
        return Status;
    }

    public void setSoTrang(String soTrang) {
        SoTrang = soTrang;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Trang{" +
                "SoTrang=" + SoTrang +
                ", Status='" + Status + '\'' +
                '}';
    }
}
