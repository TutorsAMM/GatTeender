/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.gatteender.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tutor_IUM
 */
public class GattoFactory {

    //Pattern Design Singleton
    private static GattoFactory singleton;

    public static GattoFactory getInstance() {
        if (singleton == null) {
            singleton = new GattoFactory();
        }
        return singleton;
    }
    
    //Gestione DB
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    //Fine gestione DB

    private GattoFactory() {
    }

    public Gatto getGattoById(int id) {

        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "gato", "gato");
            
            String query = 
                      "select * from gatti "
                    + "where gatto_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                Gatto current = new Gatto();
                current.setId(res.getInt("gatto_id"));
                current.setNome(res.getString("name"));
                current.setRazza(res.getString("razza"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                current.setUrlFotoProfilo(res.getString("urlFotoProfilo"));

                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String password){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "gato", "gato");
            
            String query = 
                      "select gatto_id from gatti "
                    + "where name = ? and password = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, user);
            stmt.setString(2, password);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                int id = res.getInt("gatto_id");

                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public List getGattiList() {
        List<Gatto> listaGatti = new ArrayList<Gatto>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "gato", "gato");
            
            String query = 
                      "select * from gatti";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                Gatto current = new Gatto();
                current.setId(res.getInt("gatto_id"));
                current.setNome(res.getString("name"));
                current.setRazza(res.getString("razza"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                current.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                
                listaGatti.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaGatti;
    }
    
    public List getGattiList(String name) {
        List<Gatto> listaGatti = new ArrayList<Gatto>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "gato", "gato");
            
            String query = 
                      "select * from gatti where name like ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, "%" + name + "%");
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                Gatto current = new Gatto();
                current.setId(res.getInt("gatto_id"));
                current.setNome(res.getString("name"));
                current.setRazza(res.getString("razza"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                current.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                
                listaGatti.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaGatti;
    }
    
}
