package com.example.jpa_05_monan.payload.converter;

import com.example.jpa_05_monan.entity.CongThuc;
import com.example.jpa_05_monan.payload.dto.CongThucDTO;
import com.example.jpa_05_monan.payload.request.CongThucRequest;

public class CongThucConverter {
    public CongThucDTO entityToDTO(CongThuc congThuc) {
        CongThucDTO dto = new CongThucDTO();
        dto.setMonAnId(congThuc.getMonAnId());
        dto.setNguyenLieuId(congThuc.getNguyenLieuId());
        dto.setSoLuong(congThuc.getSoLuong());
        dto.setDonViTinh(congThuc.getDonViTinh());
        return dto;
    }

    public CongThuc themCongThuc(CongThucRequest request) {
        CongThuc congThuc = new CongThuc();
        congThuc.setMonAnId(request.getMonAnId());
        congThuc.setNguyenLieuId(request.getNguyenLieuId());
        congThuc.setSoLuong(request.getSoLuong());
        congThuc.setDonViTinh(request.getDonViTinh());
        return congThuc;
    }
}
