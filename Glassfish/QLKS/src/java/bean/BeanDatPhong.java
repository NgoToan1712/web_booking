/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import dao.DAODatPhong;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import model.LsDatPhong;

/**
 *
 * @author ACER
 */
@Named(value = "beanDatPhong")
@SessionScoped
public class BeanDatPhong implements Serializable {

    private ArrayList<LsDatPhong> list = DAODatPhong.getDat();

    public BeanDatPhong() {
    }

    public ArrayList<LsDatPhong> getList() {
        return list;
    }

    public void setList(ArrayList<LsDatPhong> list) {
        this.list = list;
    }

}
