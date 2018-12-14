/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.VeiculoDAOCaracteristicas;
import api.model.Categoria;
import api.model.ConexaoDB;
import api.model.Veiculo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author liks
 */
public class VeiculoDAO implements VeiculoDAOCaracteristicas {

    private ConexaoDB conexaoDB;

    @Override
    public void insert(Veiculo veiculo) throws SQLException {

        try {
            this.conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexaoDB.conectarBD();

        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement(""
                + "INSERT INTO VEICULO ("
                    + " modelo, " // 1
                    + " ano, " // 2
                    + " fabricante, " // 3
                    + " combustivel, " // 4
                    + " kilometragem, " // 5
                    + " estado_consearvacao, "// 6
                    + " cor," // 7
                    + " fk_categoria) " // 8
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);");

        conexaoDB.preparedStatement.setString(1, veiculo.getModelo());
        conexaoDB.preparedStatement.setInt(2, veiculo.getAno());
        conexaoDB.preparedStatement.setString(3, veiculo.getFabricante());
        conexaoDB.preparedStatement.setString(4, veiculo.getCombustivel());
        conexaoDB.preparedStatement.setInt(5, veiculo.getKilometragem());
        conexaoDB.preparedStatement.setInt(6, veiculo.getEstadoConservervacao());
        conexaoDB.preparedStatement.setString(7, veiculo.getCor());

        conexaoDB.preparedStatement.setInt(8, veiculo.getCategoria().getId());
        
        
        System.out.println("QUERY PRA RODARAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + conexaoDB.preparedStatement);
        
        conexaoDB.preparedStatement.executeQuery();

        conexaoDB.fecharConexao();

    }

    @Override
    public List findCarsByCategoria(int categoria) throws SQLException {

        try {
            this.conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexaoDB.conectarBD();
        Veiculo veiculo;

        List<Veiculo> veiculos = new ArrayList<>();

        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement("SELECT * FROM Koyota.VEICULO WHERE fk_categoria = ?");

        conexaoDB.preparedStatement.setString(1, String.valueOf(categoria));

        conexaoDB.resultSet = conexaoDB.preparedStatement.executeQuery();

        while (conexaoDB.resultSet.next()) {
            veiculo = new Veiculo();

            veiculo.setAno(conexaoDB.resultSet.getInt("ano"));
            veiculo.setCombustivel(conexaoDB.resultSet.getString("combustivel"));
            veiculo.setCor(conexaoDB.resultSet.getString("cor"));
            veiculo.setEstadoConservervacao(conexaoDB.resultSet.getInt("estado_consearvacao"));
            veiculo.setFabricante(conexaoDB.resultSet.getString("fabricante"));
            veiculo.setId(conexaoDB.resultSet.getInt("pk_veiculo"));
            veiculo.setKilometragem(conexaoDB.resultSet.getInt("kilometragem"));
            veiculo.setModelo(conexaoDB.resultSet.getString("modelo"));

            veiculos.add(veiculo);
        }

        conexaoDB.fecharConexao();

        return veiculos;
    }

    @Override
    public Veiculo findById(int idVeiculo) throws SQLException {

        try {
            this.conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexaoDB.conectarBD();
        Veiculo veiculo;

        List<Veiculo> veiculos = new ArrayList<>();

        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement("SELECT * FROM Koyota.VEICULO WHERE pk_veiculo = ?");

        conexaoDB.preparedStatement.setInt(1, idVeiculo);

        conexaoDB.resultSet = conexaoDB.preparedStatement.executeQuery();

        veiculo = new Veiculo();
        veiculo.setCategoria(new Categoria());

        while (conexaoDB.resultSet.next()) {
            veiculo.setAno(conexaoDB.resultSet.getInt("ano"));
            veiculo.setCombustivel(conexaoDB.resultSet.getString("combustivel"));
            veiculo.setCor(conexaoDB.resultSet.getString("cor"));
            veiculo.setEstadoConservervacao(conexaoDB.resultSet.getInt("estado_consearvacao"));
            veiculo.setFabricante(conexaoDB.resultSet.getString("fabricante"));
            veiculo.setId(conexaoDB.resultSet.getInt("pk_veiculo"));
            veiculo.getCategoria().setId(conexaoDB.resultSet.getInt("fk_categoria"));
            veiculo.setKilometragem(conexaoDB.resultSet.getInt("kilometragem"));
            veiculo.setModelo(conexaoDB.resultSet.getString("modelo"));
        }

        conexaoDB.fecharConexao();

        return veiculo;
    }

    @Override
    public List findAll() throws SQLException {

                try {
            this.conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        conexaoDB.conectarBD();
        Veiculo veiculo;

        List<Veiculo> veiculos = new ArrayList<>();

        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement("SELECT * FROM Koyota.VEICULO");

        conexaoDB.resultSet = conexaoDB.preparedStatement.executeQuery();

        while (conexaoDB.resultSet.next()) {
            veiculo = new Veiculo();

            veiculo.setAno(conexaoDB.resultSet.getInt("ano"));
            veiculo.setCombustivel(conexaoDB.resultSet.getString("combustivel"));
            veiculo.setCor(conexaoDB.resultSet.getString("cor"));
            veiculo.setEstadoConservervacao(conexaoDB.resultSet.getInt("estado_consearvacao"));
            veiculo.setFabricante(conexaoDB.resultSet.getString("fabricante"));
            veiculo.setId(conexaoDB.resultSet.getInt("pk_veiculo"));
            veiculo.setKilometragem(conexaoDB.resultSet.getInt("kilometragem"));
            veiculo.setModelo(conexaoDB.resultSet.getString("modelo"));

            veiculos.add(veiculo);
        }

        conexaoDB.fecharConexao();

        return veiculos;
    }

    @Override
    public void update(Veiculo veiculo) throws SQLException {
        
        try {
            this.conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexaoDB.conectarBD();
        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement(""
                + "UPDATE VEICULO SET "
                    + "kilometragem = ? "
                    + ", "
                    + "estado_consearvacao = ? "
                    + "WHERE VEICULO.pk_veiculo = ? "    
                    + ";"
        ); 

        conexaoDB.preparedStatement.setInt(1, veiculo.getKilometragem());
        conexaoDB.preparedStatement.setInt(2, veiculo.getEstadoConservervacao());
        conexaoDB.preparedStatement.setInt(3, veiculo.getId());
        
        conexaoDB.preparedStatement.executeQuery();
        
        conexaoDB.fecharConexao();
    }

}
