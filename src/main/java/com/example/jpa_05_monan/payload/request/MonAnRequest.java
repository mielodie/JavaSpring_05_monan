package com.example.jpa_05_monan.payload.request;

import java.util.List;

public class MonAnRequest {
    private int loaiMonAnId;
    private String tenMonAn;
    private double giaBan;
    private String gioiThieu;
    private List<CongThucRequest> congThucRequestList;

    public List<CongThucRequest> getCongThucRequestList() {
        return congThucRequestList;
    }

    public void setCongThucRequestList(List<CongThucRequest> congThucRequestList) {
        this.congThucRequestList = congThucRequestList;
    }

    public int getLoaiMonAnId() {
        return loaiMonAnId;
    }

    public void setLoaiMonAnId(int loaiMonAnId) {
        this.loaiMonAnId = loaiMonAnId;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }
}
