/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;
import api.model.Cliente;
import api.servico.*;
import javax.websocket.ClientEndpointConfig;
/**
 *
 * @author liks
 */
public class CadastroClienteServico implements ClienteServicoCaracacteristicas{


    
    @Override
    public boolean insert(Cliente cliente) {
        
        boolean statusCadastro =true;
        
        try {
            //dao pra insert
        } catch (Exception e) {
            //pegou a excessao
        }
        
        
        return statusCadastro;
        
    }
    
}
