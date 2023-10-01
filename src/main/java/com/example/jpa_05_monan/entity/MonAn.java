package com.example.jpa_05_monan.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "monans")
public class MonAn extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "loaimonanid", insertable = false, updatable = false)
    @JsonBackReference
    private LoaiMonAn loaiMonAn;
    @Column(name = "loaimonanid")
    private int loaiMonAnId;
    @Column(name = "tenmonan")
    private String tenMonAn;
    @Column(name = "giaban")
    private double giaBan;
    @Column(name = "gioithieu")
    private String gioiThieu;
    @Column(name = "cachlam")
    private String cachLam = "";
    @OneToMany(mappedBy = "monAn")
    @JsonManagedReference
    private List<CongThuc> congThucs;

    public LoaiMonAn getLoaiMonAn() {
        return loaiMonAn;
    }

    public void setLoaiMonAn(LoaiMonAn loaiMonAn) {
        this.loaiMonAn = loaiMonAn;
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

    public String getCachLam() {
        return cachLam;
    }

    public void setCachLam(String cachLam) {
        this.cachLam = cachLam;
    }

    public List<CongThuc> getCongThucs() {
        return congThucs;
    }

    public void setCongThucs(List<CongThuc> congThucs) {
        this.congThucs = congThucs;
    }
}
