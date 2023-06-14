/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.utp.webservices;

import com.utp.model.daos.ClienteDAO;
import com.utp.model.entities.Cliente;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Admin
 */
@WebService(serviceName = "ENT_Cliente")
public class ENT_Cliente {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "insert")
    public Boolean insert(@WebParam(name = "nombre") String nombre,@WebParam(name = "apellido") String apellido,@WebParam(name = "correo") String correo,@WebParam(name = "dni") String dni) {      
       Cliente cliente = new Cliente.Builder()
                .nombre(nombre)
                .apellido(apellido)
                .correo(correo)
                .dni(dni)
                .build();
        ClienteDAO clienteDAO = new ClienteDAO();      
        return clienteDAO.insert(cliente);
    }
   @WebMethod(operationName = "list")
    public List<Cliente> listAll(){
        ClienteDAO clienteDAO = new ClienteDAO();      
        return clienteDAO.list();
    }
 

}
