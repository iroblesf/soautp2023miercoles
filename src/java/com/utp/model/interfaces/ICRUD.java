/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utp.model.interfaces;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface ICRUD <T> {
    Boolean insert(T t);
    Boolean update(T t);
    T listById(Object id);
    List<T> list(); 
    void delete();    
}
