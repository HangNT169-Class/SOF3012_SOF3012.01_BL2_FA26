package com.example.buoi9_joinbang.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@ToString
@Getter
@Setter
@Entity
@Table(name = "phieu_giam_gia")
public class PhieuGiamGia {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "loai_phieu_id", nullable = false)
    private LoaiPhieuGiamGia loaiPhieu;

    @Column(name = "ma")
    private String ma;

    @Nationalized
    @Column(name = "ten")
    private String ten;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Nationalized
    @Column(name = "loai_giam")
    private String loaiGiam;

    @Column(name = "dieu_kieu_toi_thieu")
    private String dieuKieuToiThieu;

    @Column(name = "gia_tri_toi_da")
    private String giaTriToiDa;

}