/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import model.LsDatPhong;
import dao.*;

/**
 *
 * @author ACER
 */
@Named(value = "beanDatPhong")
@ApplicationScoped
public class BeanDatPhong {

    /**
     * Creates a new instance of BeanDatPhong
     */
    private ArrayList<LsDatPhong> list =DAODatPhong.getDat();

    public BeanDatPhong() {
    }

    public ArrayList<LsDatPhong> getList() {
        return list;
    }

    public void setList(ArrayList<LsDatPhong> list) {
        this.list = list;
    }

  
}
