package com.example.buoi5_hibernate.controller;

import com.example.buoi5_hibernate.entity.Category1;
import com.example.buoi5_hibernate.repository.CategoryRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = {
        // duong dan bat dau bang dau /
        // duong dan la duy nhat
        "/category/hien-thi", // GET
        "/category/detail", // GET
        "/category/add", // POST
        "/category/update", // POST
        "/category/delete", // GET
        "/category/view-update", // GET
        "/category/view-add", // GET
        "/category/search", // GET
})
public class CategoryServlet extends HttpServlet {

    private CategoryRepository cateRepository = new CategoryRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            // hien thi
            this.hienThiDuLieu(request, response);
        } else if (uri.contains("detail")) {
            // detail
            this.detailCate(request, response);
        } else if (uri.contains("delete")) {
            // delete
            this.deleteCate(request, response);
        } else if (uri.contains("search")) {
            // search
            this.searchCate(request, response);
        } else if (uri.contains("view-update")) {
            // view - update
            this.viewUpdate(request, response);
        } else {
            // view - add
            this.viewAdd(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            // add
            this.addCate(request, response);
        } else {
            // update
            this.updateCate(request, response);
        }
    }

    private void deleteCate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = request.getParameter("id1");
        Category1 cate = cateRepository.getOne(Long.valueOf(a));
        cateRepository.delete(cate);
        // quay ve trang hien thi
        response.sendRedirect("/category/hien-thi");
    }

    private void searchCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category1> listCate1 = cateRepository.getAll();
        // hien thi listcate -> jsp
        request.setAttribute("list1", listCate1);
        // chuyen trang
        request.getRequestDispatcher("/buoi3/categorys.jsp").forward(request, response);
    }

    private void addCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateCate(HttpServletRequest request, HttpServletResponse response) {
    }

}
