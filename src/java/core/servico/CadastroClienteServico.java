/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;
import api.model.Cliente;
import api.servico.*;
import core.dao.ClienteDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.ClientEndpointConfig;
/**
 *
 * @author liks
 */
public class CadastroClienteServico implements ClienteServicoCaracacteristicas{
    
    @Override
    public boolean insert(Cliente cliente) {
        
        ClienteDAO cadastroDAO = null;
        try {
            cadastroDAO = new ClienteDAO();
        } catch (IOException ex) {
            Logger.getLogger(CadastroClienteServico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadastroDAO.insert(cliente);
        
    }
    
}
