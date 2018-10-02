/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.model.Veiculo;
import api.servico.CadastroVeiculoCaracteristicas;
import core.dao.VeiculoDAO;

/**
 *
 * @author liks
 */
public class CadastroVeiculo implements CadastroVeiculoCaracteristicas {

    @Override
    public boolean insert(Veiculo veiculo) {

        VeiculoDAO veiculoDAO = null;

        boolean status;

        veiculoDAO = new VeiculoDAO();

        veiculoDAO.insert(veiculo);
     
        return false;

    }
}
