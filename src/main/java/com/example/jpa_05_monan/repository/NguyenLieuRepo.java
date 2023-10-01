package com.example.jpa_05_monan.repository;

import com.example.jpa_05_monan.entity.NguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguyenLieuRepo extends JpaRepository<NguyenLieu, Integer> {
}
