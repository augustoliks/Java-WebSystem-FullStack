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

        PreparedStatement comandoSQLp;

        try {

            comandoSQLp = conexao.prepareStatement(""
                    + "INSERT INTO VEICULO ("
                    + " modelo, "
                    + " ano, "
                    + " fabricante, " //5
                    + " combustivel, " //6
                    + " kilometragem, " //7
                    + " estado_consearvacao, "//8
                    + " cor) " //9
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);");

            comandoSQLp.setString(1, veiculo.getModelo());
            comandoSQLp.setInt(2, veiculo.getAno());
            comandoSQLp.setString(3, veiculo.getFabricante());
            comandoSQLp.setString(4, veiculo.getCombustivel());
            comandoSQLp.setInt(5, veiculo.getKilometragem());
            comandoSQLp.setString(6, veiculo.getEstadoConservervacao());
            comandoSQLp.setString(7, veiculo.getCor());

            comandoSQLp.executeQuery();

            comandoSQLp.executeQuery();
            status = true;

        } catch (SQLException e) {
            System.out.println("Erro no insert CadastroVeiculo");
            status = false;
        }

        return status;

    }

}
