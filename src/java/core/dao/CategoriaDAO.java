/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.CategoriaDAOCaracteristicas;
import api.model.Categoria;
import api.model.Cliente;
import api.model.ConexaoDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author visita
 */
public class CategoriaDAO implements CategoriaDAOCaracteristicas{
    
    private ConexaoDB conexaoDB;
       
    @Override
    public Categoria findByName(String nomeCategoria) throws SQLException{
        Categoria categoria = null;

        try {
            conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexaoDB.conectarBD();
        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement("SELECT * FROM Koyota.CATEGORIA WHERE NOME = ?");

        conexaoDB.preparedStatement.setString(1, nomeCategoria);
        conexaoDB.resultSet = conexaoDB.preparedStatement.executeQuery();

        categoria = new Categoria();
        
        while (conexaoDB.resultSet.next()) {
            categoria.setId(conexaoDB.resultSet.getInt("pk_categoria"));
            categoria.setNome(conexaoDB.resultSet.getString("nome"));
            categoria.setValor(conexaoDB.resultSet.getFloat("valor"));
         }
        conexaoDB.fecharConexao();
        
        return categoria;
    }
    
    @Override
    public Categoria findById(int idCategoria) throws SQLException{
        Categoria categoria = null;

        try {
            conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexaoDB.conectarBD();
        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement("SELECT * FROM Koyota.CATEGORIA WHERE pk_categoria = ?");

        conexaoDB.preparedStatement.setInt(1, idCategoria);
        conexaoDB.resultSet = conexaoDB.preparedStatement.executeQuery();

        categoria = new Categoria();
        
        while (conexaoDB.resultSet.next()) {
            categoria.setId(conexaoDB.resultSet.getInt("pk_categoria"));
            categoria.setNome(conexaoDB.resultSet.getString("nome"));
            categoria.setValor(conexaoDB.resultSet.getFloat("valor"));
         }
        conexaoDB.fecharConexao();
        
        return categoria;
    }
    
    @Override
    public List findAll() throws SQLException {
        Categoria categoria;
        List<Categoria> categorias = new ArrayList<>();
        
        try {
            conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexaoDB.conectarBD();
        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement("SELECT * FROM Koyota.CATEGORIA");
        conexaoDB.resultSet = conexaoDB.preparedStatement.executeQuery();
        
        while (conexaoDB.resultSet.next()) {
            categoria = new Categoria();
            categoria.setId(conexaoDB.resultSet.getInt("pk_categoria"));
            categoria.setNome(conexaoDB.resultSet.getString("nome"));
            categoria.setValor(conexaoDB.resultSet.getInt("valor"));
            categorias.add(categoria);
        }
        
        conexaoDB.fecharConexao();
        
        return categorias;

    }
}
