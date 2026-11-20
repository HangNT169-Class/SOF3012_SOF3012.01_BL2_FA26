package com.example.buoi9_joinbang.repository;

import com.example.buoi9_joinbang.entity.PhieuGiamGia;
import com.example.buoi9_joinbang.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class PhieuGiamGiaRepository {

    private Session s;

    public PhieuGiamGiaRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<PhieuGiamGia> getAll() {
        return s.createQuery("FROM PhieuGiamGia ").list();
    }

    public static void main(String[] args) {
        System.out.println(new PhieuGiamGiaRepository().getAll());
    }
}
