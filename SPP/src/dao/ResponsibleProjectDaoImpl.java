/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import classSPP.ResponsibleProject;
import java.sql.ResultSet;
import java.sql.SQLException;
import interfaces.ResponsibleProjectDao;

/**
 *
 * @author MARTHA
 */
public class ResponsibleProjectDaoImpl implements ResponsibleProjectDao{
    ConnectionDataBase conexion=null;
    
    @Override
    public ResponsibleProject getResponsibleProject(String email) {
        ResponsibleProject responsible = new ResponsibleProject();
        try{
            conexion = new ConnectionDataBase();
            String querygetResponsibleProject= String.format("SELECT * FROM idResponsibleProject,name,lastName,email,Charge.nameCharge INNER JOIN Charge ON Charge.idCharge = ResponsibleProject.idCharge WHERE email = '"+email+"'");
            ResultSet resultResponsibleProject = conexion.query(querygetResponsibleProject).getResultSet();
            if(resultResponsibleProject!=null){
                while(resultResponsibleProject.next()){
                    responsible = new ResponsibleProject (resultResponsibleProject.getInt("idResponsibleProject"), resultResponsibleProject.getString("name"),resultResponsibleProject.getString("lastName"), resultResponsibleProject.getString("email"),resultResponsibleProject.getString("Charge.nameCharge"));
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            if(conexion!=null){
                conexion.close();
            }
        }
        return responsible;
    }

    @Override
    public void updateResponsibleProject(ResponsibleProject responsible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
