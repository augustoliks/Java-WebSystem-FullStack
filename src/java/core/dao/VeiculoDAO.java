/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.VeiculoDAOCaracteristicas;
import api.model.Veiculo;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author liks
 */
public class VeiculoDAO extends DAO implements VeiculoDAOCaracteristicas {

    @Override
    public boolean insert(Veiculo veiculo) {

        boolean status;
        
        try {

            this.preparedStatement = this.conexao.prepareStatement(""
                    + "INSERT INTO VEICULO ("
                    + " modelo, "
                    + " ano, "
                    + " fabricante, " //5
                    + " combustivel, " //6
                    + " kilometragem, " //7
                    + " estado_consearvacao, "//8
                    + " cor) " //9
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);");

            this.preparedStatement.setString(1, veiculo.getModelo());
            this.preparedStatement.setInt(2, veiculo.getAno());
            this.preparedStatement.setString(3, veiculo.getFabricante());
            this.preparedStatement.setString(4, veiculo.getCombustivel());
            this.preparedStatement.setInt(5, veiculo.getKilometragem());
            this.preparedStatement.setString(6, veiculo.getEstadoConservervacao());
            this.preparedStatement.setString(7, veiculo.getCor());

            this.preparedStatement.executeQuery();

            this.preparedStatement.executeQuery();
            status = true;

        } catch (SQLException e) {
            System.out.println("Erro no insert CadastroVeiculo");
            status = false;
        }

        return status;

    }

}
