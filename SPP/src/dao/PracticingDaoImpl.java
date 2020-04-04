package dao;

import interfaces.PracticingDao;
import classSPP.Practicing;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PracticingDaoImpl implements PracticingDao {
    private final String tablePracticing = "Practicing";
    int available=0;
    ConnectionDataBase conexion=null;
    

    @Override
    public Practicing getPracticing(String enrollment) throws SQLException {
        Practicing practicing = new Practicing();
        try{
            conexion=new ConnectionDataBase();
            String queryFoundPracticing= String.format("SELECT name, lastName, gender, email, alternateEmail, phone, enrollment, turn, period FROM "+this.tablePracticing+" WHERE enrollment = '"+enrollment+"'");
            ResultSet resultPracticing= conexion.query(queryFoundPracticing).getResultSet();
            if(resultPracticing!=null){
                while(resultPracticing.next()){
                    practicing = new Practicing(resultPracticing.getString("name"), resultPracticing.getString("lastName"),resultPracticing.getString("gender"), resultPracticing.getString("email"),resultPracticing.getString("alternateEmail"), resultPracticing.getString("phone"), resultPracticing.getString("enrollment"), resultPracticing.getString("turn"), resultPracticing.getString("period"));
                }
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }finally{
            if(conexion!=null){
                conexion.close();
            }
        }
        return practicing;
    }

    @Override
    public void updatePracticing(String enrollment, Practicing practicingEdit) throws SQLException {
      try{
            conexion=new ConnectionDataBase();
            String queryPracticingModify = String.format("update "+tablePracticing+" set name = '"+practicingEdit.getName()+"', lastName = '"+practicingEdit.getLastName()+"', gender = '"+practicingEdit.getGender()+"', email = '"+practicingEdit.getEmail()+"', alternateEmail = '"+practicingEdit.getAlternateEmail()+"', phone = '"+practicingEdit.getPhone()+"', enrollment = '"+practicingEdit.getEnrollment()+"', turn = '"+practicingEdit.getTurn()+"', period = '"+practicingEdit.getPeriod()+"' where enrollment = '"+enrollment+"'");
            ResultSet resultPracticingModify=null;
            resultPracticingModify= conexion.update(queryPracticingModify).getResultSet();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }finally{
            if(conexion!=null){
                conexion.close();
            }
        }  
    }

    @Override
    public String deletePracticing(String enrollment, Practicing practicing) throws SQLException {
        try{
            conexion =new ConnectionDataBase();
            String queryFoundEnrollment = String.format("SELECT enrollment FROM "+this.tablePracticing+" WHERE enrollment = '"+practicing.getEnrollment()+"'");
            ResultSet resultEnrollment = conexion.query(queryFoundEnrollment).getResultSet();
            enrollment = null;
            if(resultEnrollment != null){
                while(resultEnrollment.next()){
                    enrollment = resultEnrollment.getString("enrollment");
                }
            }
            if(enrollment ==null){
                return "The Practicing has not been found";
            }else{
                String queryAddPracticing = String.format("DELETE FROM "+this.tablePracticing+ " WHERE enrollment = '"+practicing.getEnrollment()+"'");
                ResultSet resultAddPracticing = null;
                resultAddPracticing = conexion.update(queryAddPracticing).getResultSet();
                return "The Practicing delete";
            }      
        }catch(SQLException ex){
            throw new SQLException(ex);
        }finally{
            if(conexion!=null){
               conexion.close();
               }
        }
    }

    @Override
    public String addPracticing(Practicing practicing) throws SQLException {
        try{
            conexion =new ConnectionDataBase();
            String queryFoundEnrollment = String.format("SELECT enrollment FROM "+this.tablePracticing+" WHERE enrollment = '"+practicing.getEnrollment()+"'");
            ResultSet resultEnrollment = conexion.query(queryFoundEnrollment).getResultSet();
            String enrollment = null;
            if(resultEnrollment != null){
                while(resultEnrollment.next()){
                    enrollment = resultEnrollment.getString("enrollment");
                }
            }
            if(enrollment ==null){
                String queryAddPracticing = String.format("INSERT INTO "+this.tablePracticing+"(name, lastName, gender, email, alternateEmail, phone, enrollment, turn, period) "
                        + "VALUES('"+practicing.getName()+"','"+practicing.getLastName()+"','"+practicing.getGender()+"','"+practicing.getEmail()+"',"+practicing.getAlternateEmail()+"','"+practicing.getPhone()+"','"+practicing.getEnrollment()+"','"+practicing.getTurn()+"','"+practicing.getPeriod()+")");
                ResultSet resultAddPracticing = null;
                resultAddPracticing = conexion.update(queryAddPracticing).getResultSet();
                return "The Practicing was an aggregator correctly.";
            }else{
                return "The Practicing was already registered";
            }      
        }catch(SQLException ex){
            throw new SQLException(ex);
        }finally{
            if(conexion!=null){
               conexion.close();
               }
        }
    }
    
}
