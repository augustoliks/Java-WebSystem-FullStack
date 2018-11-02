/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.model.Cliente;
import api.model.Operador;
import api.model.Pessoa;
import api.servico.LoginCaracteristicas;
import core.dao.ClienteDAO;
import core.dao.OperadorDAO;
import java.io.IOException;
import java.sql.SQLException;


/**
 *
 * @author liks
 */
public class LoginServico implements LoginCaracteristicas {

 
    @Override
    public Pessoa findByNomeUsuario(String nomeUsuario)  {

        ClienteDAO clienteDAO = null;
        OperadorDAO operadorDAO = null;
        
        Operador operadorBD = null;
        Cliente clienteBD = null;

        try {
            clienteDAO = new ClienteDAO();
            operadorDAO = new OperadorDAO();

            operadorBD = operadorDAO.findByName(nomeUsuario);
            clienteBD = clienteDAO.findByName(nomeUsuario);
            
        } catch (IOException ex) {
            System.out.println(ex.toString());
            return null;
      
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }

        if (operadorBD != null) {
            return operadorBD;
        } else if (clienteBD != null) {
            return clienteBD;
        } else {
            return null;
        }
    }

}
