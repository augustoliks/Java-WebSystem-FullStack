/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;
import api.dao.ClienteDAOCaracteristicas;
import api.model.Cliente;
import api.servico.*;
import core.dao.ClienteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author liks
 */
public class CadastroClienteServico implements ClienteServicoCaracacteristicas{
 
    @Override
    public boolean insersao(Cliente cliente) {
        
        ClienteDAOCaracteristicas clienteDAOImpl = null;
        boolean status = false;
        
        clienteDAOImpl = new ClienteDAO();
        
        try {
            clienteDAOImpl.insert(cliente);
            status = true;
        }
        catch (SQLException e){
            status = false;
            System.out.println(e.toString());
        }
        
        return status;
    }
    
}
