package com.example.jpa_05_monan.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
@Entity
@Table(name = "nguyenlieus")
public class NguyenLieu extends BaseEntity {
    @Column(name = "tennguyenlieu")
    private String tenNguyenLieu;
    @Column(name = "ghichu")
    private String ghiChu;
    @OneToMany(mappedBy = "nguyenLieu")
    @JsonManagedReference
    private List<CongThuc> congThucs;

    public String getTenNguyenLieu() {
        return tenNguyenLieu;
    }

    public void setTenNguyenLieu(String tenNguyenLieu) {
        this.tenNguyenLieu = tenNguyenLieu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public List<CongThuc> getCongThucs() {
        return congThucs;
    }

    public void setCongThucs(List<CongThuc> congThucs) {
        this.congThucs = congThucs;
    }
}
