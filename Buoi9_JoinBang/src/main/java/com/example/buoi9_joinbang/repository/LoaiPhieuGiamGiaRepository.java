package com.example.buoi9_joinbang.repository;

import com.example.buoi9_joinbang.entity.LoaiPhieuGiamGia;
import com.example.buoi9_joinbang.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class LoaiPhieuGiamGiaRepository {

    private Session s;

    public LoaiPhieuGiamGiaRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<LoaiPhieuGiamGia> getAll() {
        return s.createQuery("FROM LoaiPhieuGiamGia ").list();
    }

    public static void main(String[] args) {
        System.out.println(new LoaiPhieuGiamGiaRepository().getAll());
    }
}
