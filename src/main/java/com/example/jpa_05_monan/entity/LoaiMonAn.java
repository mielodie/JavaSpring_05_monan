package com.example.jpa_05_monan.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
@Entity
@Table(name = "loaimonans")
public class LoaiMonAn extends BaseEntity{
    @Column(name = "tenloai")
    private String tenLoaiMonAn;
    @Column(name = "mota")
    private String moTa;
    @OneToMany(mappedBy = "loaiMonAn")
    @JsonManagedReference
    private List<MonAn> monAns;

    public String getTenLoaiMonAn() {
        return tenLoaiMonAn;
    }

    public void setTenLoaiMonAn(String tenLoaiMonAn) {
        this.tenLoaiMonAn = tenLoaiMonAn;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public List<MonAn> getMonAns() {
        return monAns;
    }

    public void setMonAns(List<MonAn> monAns) {
        this.monAns = monAns;
    }
}
