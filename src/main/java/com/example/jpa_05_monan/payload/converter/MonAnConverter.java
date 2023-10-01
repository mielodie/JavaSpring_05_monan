package com.example.jpa_05_monan.payload.converter;

import com.example.jpa_05_monan.entity.MonAn;
import com.example.jpa_05_monan.payload.dto.MonAnDTO;
import com.example.jpa_05_monan.payload.request.MonAnRequest;

public class MonAnConverter {
    public MonAnDTO entityToDTO(MonAn monAn) {
        MonAnDTO dto = new MonAnDTO();
        dto.setTenMonAn(monAn.getTenMonAn());
        dto.setGiaBan(monAn.getGiaBan());
        dto.setGioiThieu(monAn.getGioiThieu());
        dto.setLoaiMonAnId(monAn.getLoaiMonAnId());
        dto.setCachLam(monAn.getCachLam());
        return dto;
    }

    public MonAn themMonAn(MonAnRequest request) {
        MonAn monAn = new MonAn();
        monAn.setLoaiMonAnId(request.getLoaiMonAnId());
        monAn.setTenMonAn(request.getTenMonAn());
        monAn.setGiaBan(request.getGiaBan());
        monAn.setGioiThieu(request.getGioiThieu());
        return monAn;
    }
}
