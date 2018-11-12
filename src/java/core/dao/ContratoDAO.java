/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.ContratoDAOCaracteristicas;
import api.model.Categoria;
import api.model.Cliente;
import api.model.ConexaoDB;
import api.model.Contrato;
import api.model.Operador;
import api.model.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;

/**
 *
 * @author visita
 */
public class ContratoDAO implements ContratoDAOCaracteristicas{
    ConexaoDB conexaoDB;
    
    @Override
    public void insert(Contrato contrato) throws SQLException{
    
        try {
            this.conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexaoDB.conectarBD();

        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement(""
                + "insert into contrato("
                    + "fk_reserva,"
                    + "fk_operador,"
                    + "data_hora_retirada,"
                    + "data_hora_devolucao,"    
                    + "valor_total_reserva,"
                    + "valor_pago_antecipadamente"
                + ") "
                + "values("
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?"
                + ");");

        conexaoDB.preparedStatement.setInt(1, contrato.getReserva().getId());
        conexaoDB.preparedStatement.setInt(2, contrato.getOperador().getId());
        conexaoDB.preparedStatement.setDate(3, new java.sql.Date( contrato.getDataHoraRetirada().toDate().getTime() ));
        
        try {
            conexaoDB.preparedStatement.setDate(4, new java.sql.Date( contrato.getDataHoraDevolucao().toDate().getTime() ));
        } catch (Exception e) {
            conexaoDB.preparedStatement.setNull(4, Types.DATE);
        }
        
        conexaoDB.preparedStatement.setFloat(5, contrato.getValorTotalReserva());
        conexaoDB.preparedStatement.setFloat(6, contrato.getValorPagoAntecipadamente());
        
        conexaoDB.preparedStatement.executeQuery();

    }

    @Override
    public Contrato findById(int idContrato) throws SQLException {

        try {
            conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexaoDB.conectarBD();
        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement("SELECT * FROM Koyota.CONTRATO WHERE pk_contrato = ?");

        conexaoDB.preparedStatement.setInt(1, idContrato);
        conexaoDB.resultSet = conexaoDB.preparedStatement.executeQuery();

        Contrato contratoBD = new Contrato();
        
        contratoBD.setReserva(new Reserva());
        contratoBD.setOperador(new Operador());
        
        while (conexaoDB.resultSet.next()) {
            contratoBD.setId(conexaoDB.resultSet.getInt("pk_contrato"));
            contratoBD.getReserva().setId(conexaoDB.resultSet.getInt("fk_reserva"));
            contratoBD.getOperador().setId(conexaoDB.resultSet.getInt("fk_operador"));
            contratoBD.setDataHoraRetirada(new DateTime(conexaoDB.resultSet.getDate("data_hora_retirada")));
            contratoBD.setDataHoraDevolucao(new DateTime(conexaoDB.resultSet.getDate("data_hora_devolucao")));
            contratoBD.setValorTotalReserva(conexaoDB.resultSet.getFloat("valor_total_reserva"));
            contratoBD.setValorPagoAntecipadamente(conexaoDB.resultSet.getFloat("valor_pago_antecipadamente"));
            contratoBD.setValorAcrescimo(conexaoDB.resultSet.getFloat("valor_acrescimo"));
            contratoBD.setDescricaoAcrescimo(conexaoDB.resultSet.getString("descricao_acrescimo"));
         }
        conexaoDB.fecharConexao();
        
        return contratoBD;

    }

    @Override
    public void update(Contrato contrato) throws SQLException {

        try {
            this.conexaoDB = new ConexaoDB();
        } catch (IOException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexaoDB.conectarBD();

        conexaoDB.preparedStatement = conexaoDB.conexao.prepareStatement(""
                + "UPDATE CONTRATO SET "
                    + "valor_acrescimo = ?"
                    + ", "
                    + "descricao_acrescimo = ?"
                    + ", "
                    + "data_hora_devolucao = ? "
                    + ", "
                    + "valor_total_reserva = ? "
                    + "WHERE pk_contrato = ?"    
                    + ";"
        ); 

        conexaoDB.preparedStatement.setFloat(1, contrato.getValorAcrescimo());
        conexaoDB.preparedStatement.setString(2, contrato.getDescricaoAcrescimo());
        conexaoDB.preparedStatement.setDate(3, new java.sql.Date( contrato.getDataHoraDevolucao().toDate().getTime() ) );
        conexaoDB.preparedStatement.setFloat(4, contrato.getValorTotalReserva());
        conexaoDB.preparedStatement.setInt(5, contrato.getId());
        
        conexaoDB.preparedStatement.executeQuery();
        
    }    
}
