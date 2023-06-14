/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.test;

import com.utp.model.daos.ClienteDAO;
import com.utp.model.entities.Cliente;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CrudClienteTest {
    public static void main(String[] args) {
       
        Cliente cliente = new Cliente.Builder()
                .nombre("prueba3")
                .apellido("prueba3")
                .correo("prueba3")
                .dni("dni")
                .build();
        
        ClienteDAO clienteDAO = new ClienteDAO();
        
//        if (clienteDAO.insert(cliente)) {
//            System.out.println("Se inserto el dato");
//        } else {
//            System.out.println("No se inserto el dato");
//        }
//        
        
        List<Cliente> clientes = clienteDAO.list();
        
                for (Cliente cliente1 : clientes) {
                    System.out.println(""+cliente1);
        }
    }
}
