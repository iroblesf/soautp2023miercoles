/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utp.model.interfaces;

import com.utp.model.entities.Cliente;



/**
 *
 * @author Admin
 */
public interface ICliente extends ICRUD<Cliente>{
    Cliente selectByDNI(String dni);
}
