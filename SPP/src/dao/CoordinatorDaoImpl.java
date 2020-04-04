package dao;

import interfaces.CoordinatorDao;
import classSPP.Coordinator;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinatorDaoImpl implements CoordinatorDao{
    private final String tableCoordinator = "Coordinator";
    int available=0;
    ConnectionDataBase conexion=null;
    

    @Override
    public Coordinator getCoordinator(int staffnumber) throws SQLException {
        Coordinator coordinator = new Coordinator();
        try{
            conexion=new ConnectionDataBase();
            String queryFoundCoordinator= String.format("SELECT name, lastName, gender, email, alternateEmail, phone, enrollment, turn, period FROM "+this.tableCoordinator+" WHERE enrollment = '"+staffnumber+"'");
            ResultSet resultCoordinator= conexion.query(queryFoundCoordinator).getResultSet();
            if(resultCoordinator!=null){
                while(resultCoordinator.next()){
                    coordinator = new Coordinator(resultCoordinator.getString("name"), resultCoordinator.getString("lastName"),resultCoordinator.getString("gender"), resultCoordinator.getString("email"),resultCoordinator.getString("alternateEmail"), resultCoordinator.getString("phone"), resultCoordinator.getInt("staffnumber"), resultCoordinator.getString("registrationDate"), resultCoordinator.getString("dischargeDate"));
                }
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }finally{
            if(conexion!=null){
                conexion.close();
            }
        }
        return coordinator;
    }

    @Override
    public void updateCoordinator(int staffnumber, Coordinator coordinatorEdit) throws SQLException {
      try{
            conexion=new ConnectionDataBase();
            String queryCoordinatorModify = String.format("update "+tableCoordinator+" set name = '"+coordinatorEdit.getName()+"', lastName = '"+coordinatorEdit.getLastName()+"', gender = '"+coordinatorEdit.getGender()+"', email = '"+coordinatorEdit.getEmail()+"', alternateEmail = '"+coordinatorEdit.getAlternateEmail()+"', phone = '"+coordinatorEdit.getPhone()+"', staffnumber = '"+coordinatorEdit.getStaffNumber()+"', registrationDate = '"+coordinatorEdit.getRegistrationDate()+"', disarcheDate = '"+coordinatorEdit.getDischargeDate()+"' where staffnumber = '"+staffnumber+"'");
            ResultSet resultCoordinatorModify=null;
            resultCoordinatorModify= conexion.update(queryCoordinatorModify).getResultSet();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }finally{
            if(conexion!=null){
                conexion.close();
            }
        }  
    }

    @Override
    public String deleteCoordinator(int staffnumber, Coordinator coordinator) throws SQLException {
        try{
            conexion =new ConnectionDataBase();
            String queryFoundStaffnumber = String.format("SELECT staffnumber FROM "+this.tableCoordinator+" WHERE staffnumber = '"+coordinator.getStaffNumber()+"'");
            ResultSet resultStaffnumber = conexion.query(queryFoundStaffnumber).getResultSet();
            staffnumber = 0;
            if(resultStaffnumber != null){
                while(resultStaffnumber.next()){
                    staffnumber = Integer.parseInt(resultStaffnumber.getString("staffnumber"));
                }
            }
            if(staffnumber == 0){
                return "The Coordinator has not been found";
            }else{
                String queryAddCoordinator  = String.format("DELETE FROM "+this.tableCoordinator + " WHERE staffnumber = '"+coordinator.getStaffNumber()+"'");
                ResultSet resultAddCoordinator  = null;
                resultAddCoordinator  = conexion.update(queryAddCoordinator).getResultSet();
                return "The Coordinator delete";
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
    public String addCoordinator(Coordinator coordinator) throws SQLException {
        try{
            conexion =new ConnectionDataBase();
            String queryFoundStaffnumber = String.format("SELECT staffnumber FROM "+this.tableCoordinator +" WHERE staffnumber = '"+coordinator.getStaffNumber()+"'");
            ResultSet resultStaffnumber = conexion.query(queryFoundStaffnumber).getResultSet();
            int staffNumber = 0;
            if(resultStaffnumber != null){
                while(resultStaffnumber.next()){
                    staffNumber = resultStaffnumber.getInt("staffnumber");
                }
            }
            if(staffNumber == 0){
                String queryAddCoordinator  = String.format("INSERT INTO "+this.tableCoordinator +"(name, lastName, gender, email, alternateEmail, phone, staffnumber, registrationDate, dischargeDate) "
                        + "VALUES('"+coordinator.getName()+"','"+coordinator.getLastName()+"','"+coordinator.getGender()+"','"+coordinator.getEmail()+"',"+coordinator.getAlternateEmail()+"','"+coordinator.getPhone()+"','"+coordinator.getStaffNumber()+"','"+coordinator.getRegistrationDate()+"','"+coordinator.getDischargeDate()+")");
                ResultSet resultAddCoordinator = null;
                resultAddCoordinator = conexion.update(queryAddCoordinator).getResultSet();
                return "The Coordinator was an aggregator correctly.";
            }else{
                return "The Coordinator was already registered";
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

