/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.VeiculoDAOCaracteristicas;
import api.model.ConexaoDB;
import api.model.Veiculo;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author liks
 */
public class VeiculoDAO implements VeiculoDAOCaracteristicas {

    private ConexaoDB conexaoDB;

    public VeiculoDAO() throws IOException {
        this.conexaoDB = new ConexaoDB();
    }

    @Override
    public boolean insert(Veiculo veiculo) {

        boolean status;
        
        try {
            conexaoDB.conectarBD();

            conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement(""
                    + "INSERT INTO VEICULO ("
                    + " modelo, "
                    + " ano, "
                    + " fabricante, " //5
                    + " combustivel, " //6
                    + " kilometragem, " //7
                    + " estado_consearvacao, "//8
                    + " cor) " //9
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);");

            conexaoDB.preparedStatement.setString(1, veiculo.getModelo());
            conexaoDB.preparedStatement.setInt(2, veiculo.getAno());
            conexaoDB.preparedStatement.setString(3, veiculo.getFabricante());
            conexaoDB.preparedStatement.setString(4, veiculo.getCombustivel());
            conexaoDB.preparedStatement.setInt(5, veiculo.getKilometragem());
            conexaoDB.preparedStatement.setString(6, veiculo.getEstadoConservervacao());
            conexaoDB.preparedStatement.setString(7, veiculo.getCor());

            conexaoDB.preparedStatement.executeQuery();

            conexaoDB.preparedStatement.executeQuery();
            status = true;

        } catch (SQLException e) {
            System.out.println("Erro no insert CadastroVeiculo");
            status = false;
        }

        return status;

    }

}