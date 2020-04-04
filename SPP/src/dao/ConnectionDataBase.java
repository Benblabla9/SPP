/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MARTHA
 */
public class ConnectionDataBase {
    private Connection conexion;
    private String host;
    private String dataBase;
    private String username;
    private String password;
    
    private static ConnectionDataBase connect;
    
    public ConnectionDataBase() {
        String driver = "com.mysql.jdbc.Driver";
        this.host = "localhost";
        this.dataBase = "congress";
        this.username = "root";
        this.password = "mmol180515";
        final String dataBaseURL = "jdbc:mysql://" + host + ":"+3306+"/" + dataBase+"?useTimezone=true&serverTimezone=UTC";
        try {
            conexion = DriverManager.getConnection(dataBaseURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connect = this;
    }
    
    public Connection connection() {
        try {
            return getConnection();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
//Todo lo que sea consultas con select
    public Statement query(String sQuery) throws SQLException {
        Statement s = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        s.executeQuery(sQuery);
        return s;
    }
//Los delete, crear tablas si modifica los datos.
    public Statement update(String sQuery) throws SQLException {
        Statement s = getConnection().createStatement();
        s.executeUpdate(sQuery);
        return s;
    }

    public void close(Statement s) {
        try {
            s.close();
        }catch (SQLException e) {
            System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        }
    }

    public void close() {
        try {
            if(getConnection()!=null){
                getConnection().close();   
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        }
    }

    public static ConnectionDataBase getConnect() {
        return connect;
    }

    public static void setConnect(ConnectionDataBase connect) {
        ConnectionDataBase.connect = connect;
    }

    /**
     * @return the conexion
     */
    public Connection getConnection() {
        return conexion;
    }

    /**
     * @param conn the conexion to set
     */
    public void setConnection(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
