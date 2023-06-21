/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.DatPhong;
import model.TaiKhoan;
import model.ThanhPho;
import model.ThanhToan;

/**
 *
 * @author ACER
 */
public class DAOThanhToan {

    private static Connection con;

    public List<ThanhToan> getThanhToanAll() {
        List<ThanhToan> list = new ArrayList<>();
        try {
            con = SQLConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from ThanhToan");
            while (rs.next()) {
                ThanhToan thanhToan = new ThanhToan();
                thanhToan.setThanhToanId(rs.getInt(1));
                DatPhong datPhong = dao.DAODatPhong.getById(rs.getInt(2));
                TaiKhoan taiKhoan = dao.DAOTaiKhoan.getTaiKhoan(datPhong.getTaiKhoan());
                thanhToan.setDatPhong(datPhong);
                thanhToan.setTaiKhoan(taiKhoan);
                thanhToan.setTienCoc(rs.getFloat(3));
                thanhToan.setTienThieu(rs.getFloat(4));
                thanhToan.setPhuongThuc(rs.getString(5));
                thanhToan.setNgayThanhToan(rs.getDate(6));
                thanhToan.setTrangThai(rs.getString(7));
                list.add(thanhToan);
            }
            con.close();
        } catch (Exception e) {
        }
        return list;
    }

    public ThanhToan getThanhToanById(int id) {
        ThanhToan thanhToan = new ThanhToan();
        try {
            con = SQLConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from ThanhToan where Id= " + id);
            while (rs.next()) {
                thanhToan.setThanhToanId(rs.getInt(1));
                DatPhong datPhong = dao.DAODatPhong.getById(rs.getInt(2));
                TaiKhoan taiKhoan = dao.DAOTaiKhoan.getTaiKhoan(datPhong.getTaiKhoan());
                thanhToan.setDatPhong(datPhong);
                thanhToan.setTaiKhoan(taiKhoan);
                thanhToan.setTienCoc(rs.getFloat(3));
                thanhToan.setTienThieu(rs.getFloat(4));
                thanhToan.setPhuongThuc(rs.getString(5));
                thanhToan.setNgayThanhToan(rs.getDate(6));
                thanhToan.setTrangThai(rs.getString(7));

            }
            con.close();
        } catch (Exception e) {
        }
        return thanhToan;
    }

    public static boolean insert(ThanhToan thanhToan) {
        try {
            con = SQLConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement("insert into ThanhToan values(?,?,?,?,?,?)");
            stmt.setInt(1, thanhToan.getDatPhong().getId());
            stmt.setFloat(2, thanhToan.getTienCoc());
            stmt.setFloat(3, thanhToan.getTienThieu());
            stmt.setString(4, thanhToan.getPhuongThuc());
            stmt.setDate(5, (Date) java.util.Calendar.getInstance().getTime());
            stmt.setString(6, thanhToan.getTrangThai());
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
