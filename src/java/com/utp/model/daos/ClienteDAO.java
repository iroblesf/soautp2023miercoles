/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.model.daos;

import com.utp.model.connection.ConnectionDB;
import com.utp.model.entities.Cliente;
import com.utp.model.interfaces.ICliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ClienteDAO implements ICliente {

    private static PreparedStatement pstm;
    private static ResultSet res;
    private static ConnectionDB con;

    public ClienteDAO() {
        con = ConnectionDB.getInstance();
    }

    @Override
    public Cliente selectByDNI(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean insert(Cliente t) {
        Boolean result = false;
        final String SQL_INSERT = "insert into cliente values(?,?,?,?)";
        try {
            pstm = con.getConnection().prepareStatement(SQL_INSERT);
            pstm.setString(1, t.getNombre());
            pstm.setString(2, t.getApellido());
            pstm.setString(3, t.getCorreo());
            pstm.setString(4, t.getDni());            
            if(pstm.executeUpdate()>0){
               result=true;
            }
            
        } catch (Exception e) {
            System.out.println("Error al insertar");
            e.printStackTrace();
        } finally {
          close();
        }

        return result;

    }

    @Override
    public Boolean update(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente listById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> list() {
        final String SQL_SELECT="select * from cliente";
        List<Cliente> clientes = new ArrayList<>();
        
        try {
          pstm = con.getConnection().prepareStatement(SQL_SELECT);          
          res =  pstm.executeQuery();
          
          while(res.next()){
              Cliente cliente = new Cliente.Builder()
                      .id(res.getString(1))
                      .nombre(res.getString(2))
                      .apellido(res.getString(3))
                      .correo(res.getString(4))
                      .dni(res.getString(5))
                      .build();
              clientes.add(cliente);
          }
            
        } catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
            e.printStackTrace();
        } finally {
         close();
        }        
      return clientes;

    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void close() {

        try {
            if(res!=null)res.close();
            if(pstm!=null)pstm.close();
            if(con!=null)con.close();
            
        } catch (Exception e) {
            System.out.println("Error al insertar :"+e.getMessage());
            e.printStackTrace();
        }


    }

}
