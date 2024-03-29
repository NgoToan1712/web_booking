package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.DatPhong;
import model.LsDatPhong;
import java.util.*;

public class DAODatPhong {

    private static Connection con;

    public static ArrayList<DatPhong> getAll() {
        ArrayList<DatPhong> list = new ArrayList();
        try {
            con = SQLConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from DatPhong");
            while (rs.next()) {
                DatPhong tmp = new DatPhong();
                tmp.setId(rs.getInt("Id"));
                tmp.setTaiKhoan(rs.getString("TaiKhoan"));
                tmp.setIdPhong(rs.getInt("IdPhong"));
                tmp.setNgayDat(rs.getDate("NgayDat"));
                tmp.setNgayDen(rs.getDate("NgayDen"));
                tmp.setNgayTra(rs.getDate("NgayTra"));
                tmp.setDichVu(rs.getString("DichVu"));
                tmp.setGhiChu(rs.getString("GhiChu"));
                tmp.setThanhTien(rs.getInt("ThanhTien"));
                tmp.setDaHuy(rs.getBoolean("DaHuy"));
                list.add(tmp);
            }
            con.close();
        } catch (Exception e) {
        }
        return list;
    }

    public static DatPhong getById(int id) {
        DatPhong tmp = new DatPhong();
        try {
            con = SQLConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from DatPhong where Id= " + id);
            while (rs.next()) {

                tmp.setId(rs.getInt("Id"));
                tmp.setTaiKhoan(rs.getString("TaiKhoan"));
                tmp.setIdPhong(rs.getInt("IdPhong"));
                tmp.setNgayDat(rs.getDate("NgayDat"));
                tmp.setNgayDen(rs.getDate("NgayDen"));
                tmp.setNgayTra(rs.getDate("NgayTra"));
                tmp.setDichVu(rs.getString("DichVu"));
                tmp.setGhiChu(rs.getString("GhiChu"));
                tmp.setThanhTien(rs.getInt("ThanhTien"));
                tmp.setDaHuy(rs.getBoolean("DaHuy"));
            }
            con.close();
        } catch (Exception e) {
        }
        return tmp;
    }

    public static ArrayList<LsDatPhong> getDat() {
        ArrayList<LsDatPhong> list = new ArrayList<>();
        try {
            con = SQLConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select ThanhPho.Ten as thanhpho,KhachSan.Ten as khachsan,Phong.Ten as phong,"
                    + "TaiKhoan,NgayDat,NgayDen,NgayTra,ThanhTien,DaHuy,TaiKhoan.SoDienThoai "
                    + "from (((DatPhong join Phong on DatPhong.IdPhong=Phong.Id) join KhachSan on Phong.IdKhachSan=KhachSan.Id)"
                    + " join ThanhPho on KhachSan.IdThanhPho=ThanhPho.Id) join TaiKhoan on DatPhong.TaiKhoan=TaiKhoan.TenTaiKhoan");
            while (rs.next()) {
                LsDatPhong tmp = new LsDatPhong();
                tmp.setTenThanhPho(rs.getString("thanhpho"));
                tmp.setTenKhachSan(rs.getString("khachsan"));
                tmp.setTenPhong(rs.getString("phong"));
                tmp.setTenTaiKhoan(rs.getString("TaiKhoan"));
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String NgayDat = formatter.format(rs.getDate("NgayDat"));
                tmp.setNgayDat(NgayDat);
                String NgayDen = formatter.format(rs.getDate("NgayDen"));
                tmp.setNgayDen(NgayDen);
                String NgayTra = formatter.format(rs.getDate("NgayTra"));
                tmp.setNgayTra(NgayTra);
                String thanhTien = String.format("%,d", rs.getInt("ThanhTien") * 1000);
                tmp.setThanhTien(thanhTien);
                boolean check = rs.getBoolean("DaHuy");
                String trangthai;
                if (check == true) {
                    trangthai = "Đã hủy";
                } else {
                    long millis = System.currentTimeMillis();
                    Date ngayHienTai = new Date(millis);
                    Date ngTra = rs.getDate("NgayTra");
                    if (ngTra.compareTo(ngayHienTai) < 0) {
                        trangthai = "Hoàn tất";
                    } else {
                        trangthai = "Đang đặt";
                    }

                }
                tmp.setTrangThai(trangthai);
                tmp.setSoDienThoai(rs.getString("SoDienThoai"));
                list.add(tmp);
            }
            con.close();
        } catch (Exception e) {
        }
        return list;

    }

    public static boolean insert(DatPhong tmp) {
        try {
            con = SQLConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement("insert into DatPhong output inserted.Id values(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, tmp.getTaiKhoan());
            stmt.setInt(2, tmp.getIdPhong());
            stmt.setDate(3, new java.sql.Date(tmp.getNgayDat().getTime()));
            stmt.setDate(4, new java.sql.Date(tmp.getNgayDen().getTime()));
            stmt.setDate(5, new java.sql.Date(tmp.getNgayTra().getTime()));
            stmt.setString(6, tmp.getDichVu());
            stmt.setString(7, tmp.getGhiChu());
            stmt.setInt(8, tmp.getThanhTien());
            stmt.setBoolean(9, tmp.isDaHuy());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tmp.setId(rs.getInt("Id"));
            }
            con.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean update(int id) {
        try {
            con = SQLConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement("update DatPhong set DaHuy=? where Id=?");
            stmt.setBoolean(1, true);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean delete(int id) {
        try {

        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
