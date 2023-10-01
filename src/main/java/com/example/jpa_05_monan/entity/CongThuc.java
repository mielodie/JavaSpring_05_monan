package com.example.jpa_05_monan.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "congthucs")
public class CongThuc extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "monanid", insertable = false, updatable = false)
    @JsonBackReference
    private MonAn monAn;
    @Column(name = "monanid")
    private int monAnId;
    @ManyToOne
    @JoinColumn(name = "nguyenlieuid", insertable = false, updatable = false)
    @JsonBackReference
    private NguyenLieu nguyenLieu;
    @Column(name = "nguyenlieuid")
    private int nguyenLieuId;
    @Column(name = "soluong")
    private int soLuong;
    @Column(name = "donvitinh")
    private String donViTinh;

    public MonAn getMonAn() {
        return monAn;
    }

    public void setMonAn(MonAn monAn) {
        this.monAn = monAn;
    }

    public int getMonAnId() {
        return monAnId;
    }

    public void setMonAnId(int monAnId) {
        this.monAnId = monAnId;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }

    public int getNguyenLieuId() {
        return nguyenLieuId;
    }

    public void setNguyenLieuId(int nguyenLieuId) {
        this.nguyenLieuId = nguyenLieuId;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }
}
