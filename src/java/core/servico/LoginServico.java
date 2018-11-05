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
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author liks
 */
public class LoginServico implements LoginCaracteristicas {


    @Override
    public Pessoa findByNomeUsuario(String nomeUsuario)  {
        
        Operador operadorBD = null;
        Cliente clienteBD = null;
        
        ClienteDAO clienteDAO = new ClienteDAO();
        OperadorDAO operadorDAO = new OperadorDAO();
        
        try {
            operadorBD = operadorDAO.findByName(nomeUsuario);
            clienteBD = clienteDAO.findByName(nomeUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServico.class.getName()).log(Level.SEVERE, null, ex);
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
