package com.example.jpa_05_monan.controller;

import com.example.jpa_05_monan.entity.CongThuc;
import com.example.jpa_05_monan.payload.dto.LoaiMonAnDTO;
import com.example.jpa_05_monan.payload.dto.MonAnDTO;
import com.example.jpa_05_monan.payload.request.CongThucRequest;
import com.example.jpa_05_monan.payload.request.LoaiMonAnRequest;
import com.example.jpa_05_monan.payload.request.MonAnRequest;
import com.example.jpa_05_monan.payload.response.ResponseObject;
import com.example.jpa_05_monan.service.MonAnService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MonAnController {
    private final MonAnService _monAnService;

    public MonAnController(MonAnService monAnService) {
        _monAnService = monAnService;
    }

    @PostMapping(value = "themmonan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<MonAnDTO> themMonAn(@RequestBody MonAnRequest request) {
        return _monAnService.themMonAn(request);
    }

    //    @PostMapping(value = "themcongthuc", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<CongThuc> themDanhSachCongThuc(@RequestParam int monAnId, @RequestParam int soLuongCongThuc, @RequestBody CongThucRequest request){
//        return _monAnService.themDanhSachCongThuc(monAnId, soLuongCongThuc, request);
//    }
    @DeleteMapping(value = "xoaloaimonan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<LoaiMonAnDTO> xoaLoaiMonAn(@RequestParam int loaiMonAnId) {
        return _monAnService.xoaLoaiMonAn(loaiMonAnId);
    }
    @GetMapping(value = "timkiem", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonAnDTO> timKiemMonAn(@RequestParam String tenMonAn, @RequestParam String tenNguyenLieu) {
        return _monAnService.timKiemMonAn(tenMonAn, tenNguyenLieu);
    }
}
