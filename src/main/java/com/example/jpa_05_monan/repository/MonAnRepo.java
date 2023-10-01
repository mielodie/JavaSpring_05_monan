package com.example.jpa_05_monan.repository;

import com.example.jpa_05_monan.entity.MonAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonAnRepo extends JpaRepository<MonAn, Integer> {
}
