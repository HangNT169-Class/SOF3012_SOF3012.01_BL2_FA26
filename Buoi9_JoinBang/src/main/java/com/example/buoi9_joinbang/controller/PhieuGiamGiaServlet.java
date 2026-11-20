package com.example.buoi9_joinbang.controller;

import com.example.buoi9_joinbang.repository.LoaiPhieuGiamGiaRepository;
import com.example.buoi9_joinbang.repository.PhieuGiamGiaRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PhieuGiamGiaServlet", value = "/phieu-giam-gia/hien-thi")
public class PhieuGiamGiaServlet extends HttpServlet {

    private PhieuGiamGiaRepository pggRepo = new PhieuGiamGiaRepository();

    private LoaiPhieuGiamGiaRepository loaiPhieuRepo = new LoaiPhieuGiamGiaRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiDuLieu(request, response);
        }
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listLoaiPhieu", loaiPhieuRepo.getAll());
        request.setAttribute("listPhieu", pggRepo.getAll());
        request.getRequestDispatcher("/phieu-hien-thi.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
