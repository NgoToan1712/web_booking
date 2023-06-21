/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class ThanhToan {

    private int thanhToanId;
    private TaiKhoan taiKhoan;
    private DatPhong datPhong;
    private float tienCoc;
    private float tienThieu;
    private String phuongThuc;
    private Date ngayThanhToan;
    private String trangThai;

    public ThanhToan() {
    }

    public ThanhToan(int thanhToanId, TaiKhoan taiKhoan, DatPhong datPhong, float tienCoc, float tienThieu, String phuongThuc, Date ngayThanhToan, String trangThai) {
        this.thanhToanId = thanhToanId;
        this.taiKhoan = taiKhoan;
        this.datPhong = datPhong;
        this.tienCoc = tienCoc;
        this.tienThieu = tienThieu;
        this.phuongThuc = phuongThuc;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
    }

    public int getThanhToanId() {
        return thanhToanId;
    }

    public void setThanhToanId(int thanhToanId) {
        this.thanhToanId = thanhToanId;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public DatPhong getDatPhong() {
        return datPhong;
    }

    public void setDatPhong(DatPhong datPhong) {
        this.datPhong = datPhong;
    }

    public float getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(float tienCoc) {
        this.tienCoc = tienCoc;
    }

    public float getTienThieu() {
        return tienThieu;
    }

    public void setTienThieu(float tienThieu) {
        this.tienThieu = tienThieu;
    }

    public String getPhuongThuc() {
        return phuongThuc;
    }

    public void setPhuongThuc(String phuongThuc) {
        this.phuongThuc = phuongThuc;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
