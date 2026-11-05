package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Value: chứa các đường dẫn theo yêu cầu của đề
@WebServlet(name = "DangKyServlet", value = {
        "/dang-ky",
        "/ket-qua"
})
public class DangKyServlet extends HttpServlet {
    // 2 phuong thuc: GET & POST
    // FORM -> AN THONG TIN -> POST
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/dang-ki-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Can lay gia tri input -> jsp: request.getParameter
        // B1: Lay gia tri jsp
        String ma = request.getParameter("mssv");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String chuyenNganh = request.getParameter("chuyenNganh");
        // B2: Truyen gia tri sang trang moi ket-qua
        // Truyen gia tri servlet -> jsp: request.setAttribute
        request.setAttribute("a", ma);
        request.setAttribute("a1", ten);
        request.setAttribute("a2", tuoi);
        request.setAttribute("a3", gioiTinh);
        request.setAttribute("a4", chuyenNganh);
        // B3: Chuyen trang ket qua
        request.getRequestDispatcher("/ket-qua-hien-thi.jsp").forward(request, response);
    }
}
