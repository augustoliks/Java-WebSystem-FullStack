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

/**
 *
 * @author liks
 */
public class CadastroClienteServico implements ClienteServicoCaracacteristicas{
    
    ClienteDAOCaracteristicas clienteDAOImpl;

    public CadastroClienteServico() throws IOException {
        clienteDAOImpl = new ClienteDAO();
    } 
    
    @Override
    public boolean insersao(Cliente cliente) {
        
        boolean status = false;
        
        try {
            clienteDAOImpl.insert(cliente);
            status = true;
        }
        catch (SQLException e){
            status = false;
        }
        
        return status;
    }
    
}
