/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.ContratoDAOCaracteristicas;
import api.model.Cliente;
import api.model.ConexaoDB;
import api.model.Contrato;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                + "INSERT INTO CONTRATO ("
                    + "fk_reserva, "
                    + "fk_operador, "
                    + "data_hora_retirada, "
                    + "data_hora_devolucao"    
                    + "valor_total_reserva, "
                    + "valor_pago_antecipadamente,"
                    
                + ") "
                + "VALUES ("
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
        conexaoDB.preparedStatement.setDate(4, new java.sql.Date( contrato.getDataHoraDevolucao().toDate().getTime() ));
        conexaoDB.preparedStatement.setFloat(5, contrato.getValorTotalReserva());
        conexaoDB.preparedStatement.setFloat(6, contrato.getValorPagoAntecipadamente());
        
        conexaoDB.preparedStatement.executeQuery();

    }

    @Override
    public Contrato findById(int idCategoria) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                + "UPDATE CONTRATO SET"
                    + "valor_acrescimo = ?"
                    + ","
                    + "descricao_acrescimo = ?"
                    + ","
                    + "data_hora_devolucao = ?"
                    + "where pk_contrato = ?"    
                    + ";"
        );
                    

        conexaoDB.preparedStatement.setFloat(1, contrato.getValorAcrescimo());
        conexaoDB.preparedStatement.setString(2, contrato.getDescricaoAcrescimo());
        conexaoDB.preparedStatement.setDate(3, new java.sql.Date( contrato.getDataHoraDevolucao().toDate().getTime() ) );
        conexaoDB.preparedStatement.setFloat(4, contrato.getId());
        
        conexaoDB.preparedStatement.executeQuery();


    }

    
}
