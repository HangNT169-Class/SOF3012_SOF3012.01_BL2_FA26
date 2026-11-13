package com.example.buoi5_hibernate.repository;

import com.example.buoi5_hibernate.entity.Category1;
import com.example.buoi5_hibernate.util.HibernateUtil;
import jakarta.persistence.Query;
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

    public List<Category1> getAll() {
        return s.createQuery("FROM Category1").list();
    }

    public Category1 getOne(Long id1) {
        return s.find(Category1.class, id1);
    }

    public void add(Category1 cate) {
        try {
            s.getTransaction().begin();
            s.persist(cate);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void update(Category1 cate) {
        try {
            s.getTransaction().begin();
            s.merge(cate);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void delete(Category1 cate) {
        try {
            s.getTransaction().begin();
            s.delete(cate);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    // 1. Tim kiem danh sach cate theo ten - chua ten
    // 2. Tim kiem ds cate theo khoang id
    // 3. Sap xep giam danh theo id
    // 4. Phan trang - 3 phan tu /trang
    public List<Category1> searchByName(String name) {
        // B1: Tao query
        String hql = "SELECT c FROM Category1 c WHERE c.categoryName LIKE ?1";
        // B2: Khoi tao query
        Query q = s.createQuery(hql);
        // B3: Set tham so cho dau ?
        q.setParameter(1, "%" + name + "%");
        // B4: Return list
        return q.getResultList();
        // NEU HAM TRA VE DS -> getResultList
        // NEU HAM TRA VE 1 DOI TUONG -> getSingleResult
    }

    public Category1 getOne2(Long id) {
        String hql = "SELECT c FROM Category1 c WHERE c.id = ?1";
        Query q = s.createQuery(hql);
        q.setParameter(1, id);
        return (Category1) q.getSingleResult();
    }
    // phan trang => dung offset trong SQL

    /**
     * -- giai thich ham nay la gi lam gi
     *
     * @param pageNo:   gt gia tri cua bien nay: so Trang (trang so 1, trang 2..)
     * @param pageSize: so luong phan tu trong 1 trang
     * @return : gt gia tri tra ve
     */
    public List<Category1> phanTrangSQl(Integer pageNo, Integer pageSize) {
        // TRANG DAU TIEN BAT DAU BANG 0
        Integer offset1 = pageNo * pageSize;
        // B1: Tao cau lenh SQL
//        String sql = "SELECT * from category " +
//                "ORDER BY id  " +
//                "OFFSET :offset ROWS \n" +
//                "FETCH NEXT :pageSize1 ROWS ONLY ";
        String sql = "select * from category ORDER BY id  OFFSET :offset ROWS FETCH NEXT :pageSize1 ROWS ONLY;";
//        String sql1="select * from category\n" +
//                "ORDER BY id \n" +
//                "OFFSET9 ROWS \n" +
//                "FETCH NEXT 3 ROWS ONLY ";
        // B2: Tao query
        Query query = s.createNativeQuery(sql, Category1.class);
        // B3: Set value
        query.setParameter("offset", offset1);
        query.setParameter("pageSize1", pageSize);
        return query.getResultList();
    }

    public List<Category1> phanTrangHQl(Integer pageNo, Integer pageSize) {
        int offset = pageNo * pageSize;
        String hql = "SELECT p FROM Category1 p  ORDER BY p.id ";
        Query query = s.createQuery(hql);
        query.setFirstResult(offset); // NGANG HANG VS OFFSET => KET QUA TRA RA LA +1
        query.setMaxResults(pageSize); // SO LUONG MAX/TRANG
        return query.getResultList();
    }

    public List<Category1> getAll1() {
        String hql = "SELECT c FROM Category1 c ";
        Query q = s.createQuery(hql);
        return q.getResultList();
    }

    public List<Category1> search() {
        String hql = "SELECT c FROM Category1 c ORDER BY c.id DESC";
        Query q = s.createQuery(hql);
        return q.getResultList();
    }

    // Category is not mapped
    // 1. Class trong Category chua co @Entity
    // 2. Chua dk su dung class entity ben Hibernate Util
    public static void main(String[] args) {
        System.out.println(new CategoryRepository().searchByName("e"));
    }
}
