/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolbox.readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author liks
 */
public class LeitorPropiedadesBancoDados {

    private static final String DIRETORIO = "src/java/resources/bancoDados.properties";

    public Properties prop;
    public InputStream input;

    public LeitorPropiedadesBancoDados() throws FileNotFoundException, IOException {
        this.prop = new Properties();
//        this.input = new FileInput Stream("src/java/resources/bancoDados.properties");
//        this.prop.load(input);
    }

    public String getUsuario() throws FileNotFoundException, IOException {
     //   return prop.getProperty("USUARIO");
        return "augustoliks";
    }

    public String getSenha() throws FileNotFoundException, IOException {
       // return prop.getProperty("SENHA");
        return "root";
    }

    public String getEndereco() throws FileNotFoundException, IOException {
      //  return prop.getProperty("ENDERECO");
        return "127.0.0.1";
    }

    public String getBaseDados() throws FileNotFoundException, IOException {
        //return prop.getProperty("BASE_DADOS");
        return "Koyota";
    }

    public String getModulo() throws FileNotFoundException, IOException {
        //return prop.getProperty("MODULO");
        return "jdbc";
    }    

    public String getSGBD() throws FileNotFoundException, IOException {
        //return prop.getProperty("SGBD");
        return "mariadb";
    }            
    
}
