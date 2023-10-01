package com.example.jpa_05_monan.service.interfaceservice;

import com.example.jpa_05_monan.entity.CongThuc;
import com.example.jpa_05_monan.payload.dto.LoaiMonAnDTO;
import com.example.jpa_05_monan.payload.dto.MonAnDTO;
import com.example.jpa_05_monan.payload.request.CongThucRequest;
import com.example.jpa_05_monan.payload.request.LoaiMonAnRequest;
import com.example.jpa_05_monan.payload.request.MonAnRequest;
import com.example.jpa_05_monan.payload.response.ResponseObject;

import java.util.List;

public interface iMonAnService {
//    public List<CongThuc> themDanhSachCongThuc(int monAnId, int soLuongCongThuc, CongThucRequest request);
    public List<CongThuc> themDanhSachCongThuc(List<CongThucRequest> requests, int monAnId);
    public ResponseObject<MonAnDTO> themMonAn(MonAnRequest request);
    public ResponseObject<LoaiMonAnDTO> xoaLoaiMonAn(int loaiMonAnId);
    public List<MonAnDTO> timKiemMonAn(String tenMonAn, String tenNguyenLieu);
}
