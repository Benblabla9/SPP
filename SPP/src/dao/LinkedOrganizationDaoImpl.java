/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import classSPP.LinkedOrganization;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import interfaces.LinkedOrganizationDao;

/**
 *
 * @author MARTHA
 */
public class LinkedOrganizationDaoImpl implements LinkedOrganizationDao{
    ConnectionDataBase conexion=null;
    
    @Override
    public List<LinkedOrganization> getAllLinkedOrganization() {
        List<LinkedOrganization> linkedOrganizations = new ArrayList<>();
        try{
            conexion =new ConnectionDataBase();
            String queryLinkedOrganization=  String.format("SELECT idLinkedOrganization,name,directUsers,indirectUsers,email,phoneNumber,adress,City.namecity,State.nameState,Sector.nameSector FROM LinkedOrganization INNER JOIN City ON city.idCity = LinkedOrganization.idCity INNER JOIN State ON State.idState = LinkedOrganization.idState INNER JOIN Sector ON Sector.idSector = LinkedOrganization.idSector");
            ResultSet resultLinkedOrganizations= conexion.query(queryLinkedOrganization).getResultSet();
            while(resultLinkedOrganizations.next()){
                linkedOrganizations.add(new LinkedOrganization (resultLinkedOrganizations.getInt("idLinkedOrganization"), resultLinkedOrganizations.getString("name"),resultLinkedOrganizations.getInt("directUsers"),resultLinkedOrganizations.getInt("indirectUsers"),resultLinkedOrganizations.getString("email"),resultLinkedOrganizations.getString("phoneNumber"),resultLinkedOrganizations.getString("adress"),resultLinkedOrganizations.getString("city.nameCity"),resultLinkedOrganizations.getString("State.nameState"),resultLinkedOrganizations.getString("Sector.nameSector")));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
              if(conexion!=null){
                  conexion.close();
              }
        }
        return linkedOrganizations;
    }

    @Override
    public LinkedOrganization getLinkedOrganization(String name) {
        LinkedOrganization linkedOrganization = new LinkedOrganization();
        try{
            conexion = new ConnectionDataBase();
            String querygetLinkedOrganization= String.format("SELECT idLinkedOrganization,name,directUsers,indirectUsers,email,phoneNumber,adress,City.namecity,State.nameState,Sector.nameSector FROM LinkedOrganization INNER JOIN City ON city.idCity = LinkedOrganization.idCity INNER JOIN State ON State.idState = LinkedOrganization.idState INNER JOIN Sector ON Sector.idSector = LinkedOrganization.idSector WHERE name = '"+name+"'");
            ResultSet resultLinkedOrganization = conexion.query(querygetLinkedOrganization).getResultSet();
            if(resultLinkedOrganization!=null){
                while(resultLinkedOrganization.next()){
                    linkedOrganization = new LinkedOrganization (resultLinkedOrganization.getInt("idLinkedOrganization"), resultLinkedOrganization.getString("name"),resultLinkedOrganization.getInt("directUsers"), resultLinkedOrganization.getInt("indirectUsers"),resultLinkedOrganization.getString("email"), resultLinkedOrganization.getString("phoneNumber"), resultLinkedOrganization.getString("adress"), resultLinkedOrganization.getString("city.nameCity"), resultLinkedOrganization.getString("State.nameState"), resultLinkedOrganization.getString("Sector.nameSector"));
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            if(conexion!=null){
                conexion.close();
            }
        }
        return linkedOrganization;
    }

    @Override
    public void updateLinkedOrganization(LinkedOrganization organization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
