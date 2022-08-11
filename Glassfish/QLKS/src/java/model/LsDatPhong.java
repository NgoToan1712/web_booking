/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ACER
 */
public class LsDatPhong implements Serializable {

    String tenThanhPho;
    String tenKhachSan;
    String tenPhong;
    String tenTaiKhoan;
    String ngayDat;
    String ngayDen;
    String ngayTra;
    String thanhTien;
    String trangThai;
    String soDienThoai;

    public LsDatPhong() {
    }

    public LsDatPhong(String tenThanhPho, String tenKhachSan, String tenPhong, String tenTaiKhoan, String ngayDat, String ngayDen, String ngayTra, String thanhTien, String trangThai,String soDienThoai) {
        this.tenThanhPho = tenThanhPho;
        this.tenKhachSan = tenKhachSan;
        this.tenPhong = tenPhong;
        this.tenTaiKhoan = tenTaiKhoan;
        this.ngayDat = ngayDat;
        this.ngayDen = ngayDen;
        this.ngayTra = ngayTra;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
        this.soDienThoai=soDienThoai;
    }

    public LsDatPhong(LsDatPhong dp) {
        this.tenThanhPho = dp.tenThanhPho;
        this.tenKhachSan = dp.tenKhachSan;
        this.tenPhong = dp.tenPhong;
        this.tenTaiKhoan = dp.tenTaiKhoan;
        this.ngayDat = dp.ngayDat;
        this.ngayDen = dp.ngayDen;
        this.ngayTra = dp.ngayTra;
        this.thanhTien = dp.thanhTien;
        this.trangThai = dp.trangThai;
        this.soDienThoai=dp.soDienThoai;
    }

    public String getTenThanhPho() {
        return tenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        this.tenThanhPho = tenThanhPho;
    }

    public String getTenKhachSan() {
        return tenKhachSan;
    }

    public void setTenKhachSan(String tenKhachSan) {
        this.tenKhachSan = tenKhachSan;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getNgayDen() {
        return ngayDen;
    }

    public void setNgayDen(String ngayDen) {
        this.ngayDen = ngayDen;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(String thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

}
