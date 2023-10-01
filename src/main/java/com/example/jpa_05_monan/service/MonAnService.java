package com.example.jpa_05_monan.service;

import com.example.jpa_05_monan.entity.CongThuc;
import com.example.jpa_05_monan.entity.MonAn;
import com.example.jpa_05_monan.payload.converter.CongThucConverter;
import com.example.jpa_05_monan.payload.converter.MonAnConverter;
import com.example.jpa_05_monan.payload.dto.LoaiMonAnDTO;
import com.example.jpa_05_monan.payload.dto.MonAnDTO;
import com.example.jpa_05_monan.payload.request.CongThucRequest;
import com.example.jpa_05_monan.payload.request.MonAnRequest;
import com.example.jpa_05_monan.payload.response.ResponseObject;
import com.example.jpa_05_monan.repository.CongThucRepo;
import com.example.jpa_05_monan.repository.LoaiMonAnRepo;
import com.example.jpa_05_monan.repository.MonAnRepo;
import com.example.jpa_05_monan.repository.NguyenLieuRepo;
import com.example.jpa_05_monan.service.interfaceservice.iMonAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonAnService implements iMonAnService {
    @Autowired
    private MonAnRepo _monAnRepo;
    @Autowired
    private LoaiMonAnRepo _loaiMonAnRepo;
    @Autowired
    private NguyenLieuRepo _nguyenLieuRepo;
    @Autowired
    private CongThucRepo _congThucRepo;
    public ResponseObject<MonAnDTO> _monAnDTOResponseObject;
    public ResponseObject<LoaiMonAnDTO> _loaiMonAnDTOResponseObject;
    public MonAnConverter _monAnConverter;
    public CongThucConverter _congThucConverter;

    public MonAnService() {
        _monAnConverter = new MonAnConverter();
        _congThucConverter = new CongThucConverter();
        _monAnDTOResponseObject = new ResponseObject<MonAnDTO>();
        _loaiMonAnDTOResponseObject = new ResponseObject<LoaiMonAnDTO>();
    }

//    public List<CongThuc> themDanhSachCongThuc(CongThucRequest request) {
//        var checkMonAn = _monAnRepo.findById(request.getMonAnId());
//        if (checkMonAn.isEmpty()) {
//            throw new IllegalArgumentException("Mon an khong ton tai");
//        } else {
//            List<CongThuc> congThucs = new ArrayList<>();
//            for (int i = 0; ; i++) {
//                CongThuc congThuc = _congThucConverter.themCongThuc(request);
//                var checkNguyenLieu = _nguyenLieuRepo.findById(congThuc.getNguyenLieuId());
//                if (checkNguyenLieu.isEmpty()) {
//                    throw new IllegalArgumentException("Nguyen lieu khong ton tai");
//                } else {
//                    congThucs.add(congThuc);
//                    _congThucRepo.save(congThuc);
//                    checkMonAn.get().setCachLam(checkNguyenLieu.get().getTenNguyenLieu() + " : " + congThuc.getSoLuong() + " " + congThuc.getDonViTinh());
//                }
//                if (i < soLuongCongThuc) {
//                    break;
//                }
//            }
//            _congThucRepo.saveAll(congThucs);
//            return congThucs;
//        }
//    }


    public ResponseObject<MonAnDTO> themMonAn(MonAnRequest request) {
        var checkLoaiMonAn = _loaiMonAnRepo.findById(request.getLoaiMonAnId());

        if (checkLoaiMonAn.isEmpty()) {
            return _monAnDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Không tìm thấy loại món ăn", null);
        } else {
            var monAn = _monAnConverter.themMonAn(request);
            monAn.setLoaiMonAn(checkLoaiMonAn.get());

            _monAnRepo.save(monAn);

            List<CongThuc> savedCongThucs = themDanhSachCongThuc(request.getCongThucRequestList(), monAn.getId());
            monAn.setCongThucs(savedCongThucs);

            return _monAnDTOResponseObject.responseSuccess("Thêm món ăn thành công", _monAnConverter.entityToDTO(monAn));
        }
    }

    public List<CongThuc> themDanhSachCongThuc(List<CongThucRequest> requests, int monAnId) {
        List<CongThuc> list = new ArrayList<>();
        for (CongThucRequest request : requests) {
            var checkMonAn = _monAnRepo.findById(monAnId);
            if (checkMonAn.isEmpty()) {

                return null;
            } else {
                CongThuc congThuc = new CongThuc();
                congThuc.setMonAnId(monAnId);
                congThuc.setNguyenLieuId(request.getNguyenLieuId());
                congThuc.setSoLuong(request.getSoLuong());
                congThuc.setDonViTinh(request.getDonViTinh());
                var nguyenLieu = _nguyenLieuRepo.findById(congThuc.getNguyenLieuId());
                if (nguyenLieu.isEmpty()) {
                    return null;
                } else {
                    list.add(congThuc);
                    _congThucRepo.save(congThuc);
                    checkMonAn.get().setCachLam(checkMonAn.get().getCachLam() + nguyenLieu.get().getTenNguyenLieu() + " : " + congThuc.getSoLuong() + " " + congThuc.getDonViTinh() + " | ");
                    _monAnRepo.save(checkMonAn.get());
                }
            }
        }
        return list;
    }

    public ResponseObject<LoaiMonAnDTO> xoaLoaiMonAn(int loaiMonAnId) {
        try {
            var checkLoai = _loaiMonAnRepo.findById(loaiMonAnId).orElse(null);
            if (checkLoai == null) {
                return _loaiMonAnDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Khong tim thay loai mon an", null);
            }
            _loaiMonAnRepo.delete(checkLoai);
            return _loaiMonAnDTOResponseObject.responseSuccess("Xoa loai mon an thanh cong", null);
        }
        catch (Exception e){
            return _loaiMonAnDTOResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, e.getMessage(), null);
        }
    }


    public List<MonAnDTO> timKiemMonAn(String tenMonAn, String tenNguyenLieu) {
        List<MonAn> monAns = _monAnRepo.findAll()
                .stream()
                .filter(x -> x.getTenMonAn().trim().toLowerCase().contains(tenMonAn.trim().toLowerCase()))
                .collect(Collectors.toList());
        System.out.println(monAns.size());
        List<MonAn> list = new ArrayList<>();
        for(int i = 0; i < monAns.size(); i++){
            if(monAns.get(i).getCongThucs().stream().anyMatch(y -> y.getNguyenLieu().getTenNguyenLieu().equalsIgnoreCase(tenNguyenLieu))){
               list.add(monAns.get(i));
            }
        }

        return list.stream()
                .map(x -> _monAnConverter.entityToDTO(x))
                .collect(Collectors.toList());
    }

}
