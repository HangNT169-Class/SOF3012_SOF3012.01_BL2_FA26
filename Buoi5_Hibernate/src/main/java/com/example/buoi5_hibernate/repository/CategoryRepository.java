package com.example.buoi5_hibernate.repository;

import com.example.buoi5_hibernate.entity.Category;
import com.example.buoi5_hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CategoryRepository {
    // CRUD
    // B1: Mo phien lam viec session
    private Session s;

    // Chuot phai -> Generate -> Contructor -> Select None
    public CategoryRepository() {
        // tao phien lam viec
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<Category> getAll() {
        return s.createQuery("FROM Category").list();
    }

    public Category getOne(Long id1) {
        return s.find(Category.class, id1);
    }

    public void add(Category cate) {
        try {
            s.getTransaction().begin();
            s.persist(cate);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void update(Category cate) {
        try {
            s.getTransaction().begin();
            s.merge(cate);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void delete(Category cate) {
        try {
            s.getTransaction().begin();
            s.delete(cate);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    // Category is not mapped
    // 1. Class trong Category chua co @Entity
    // 2. Chua dk su dung class entity ben Hibernate Util
    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getOne(1L));
    }
}
