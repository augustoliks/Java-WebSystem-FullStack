/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.VeiculoDAOCaracteristicas;
import api.model.Veiculo;
import java.sql.PreparedStatement;

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
                    + " modelo, " //2
                    + " ano, " //4
                    + " fabricante, " //5
                    + " combustivel, " //6
                    + " kilometragem, " //7
                    + " estado_consearvacao, "//8
                    + " cor) " //9
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);");

            comandoSQLp.setString(1, veiculo.getModelo());    //2
            comandoSQLp.setInt(2, veiculo.getAno());          //3
            comandoSQLp.setString(3, veiculo.getFabricante());              //4
            comandoSQLp.setString(4, veiculo.getCombustivel());       //5
            comandoSQLp.setInt(5, veiculo.getKilometragem());       //6
            comandoSQLp.setString(6, veiculo.getEstadoConservervacao());               //7
            comandoSQLp.setString(7, veiculo.getCor());                  //8

            comandoSQLp.executeQuery();

            comandoSQLp.executeQuery();
            status = true;

        } catch (Exception e) {
            System.out.println("Erro no insert CadastroVeiculo");
            status = false;
        }

        return status;

    }

}

