/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import classSPP.LinkedOrganization;
import classSPP.Project;
import classSPP.ResponsibleProject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import interfaces.ProjectDao;

/**
 *
 * @author MARTHA
 */
public class ProjectDaoImpl implements ProjectDao {
    ConnectionDataBase conexion=null;
    

    @Override
    public List<Project> getAllProjects(){
        List<Project> projects = new ArrayList<>();
        try{
            conexion =new ConnectionDataBase();
            String queryProject=  String.format("SELECT *FROM Project");
            ResultSet resultProjects= conexion.query(queryProject).getResultSet();
            while(resultProjects.next()){
                projects.add(new Project(resultProjects.getInt("idProject"), resultProjects.getString("nameProject"),resultProjects.getString("description"), resultProjects.getString("objetiveGeneral"),resultProjects.getString("objetiveInmediate"), resultProjects.getString("objetiveMediate"), resultProjects.getString("methodology"), resultProjects.getString("resources"), resultProjects.getString("activities"), resultProjects.getString("responsabilities"), resultProjects.getInt("duration"), resultProjects.getInt("quiantityPracticing")));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
              if(conexion!=null){
                  conexion.close();
              }
        }
        return projects;
    }

    @Override
    public Project getProject(String nameProject) {
        Project project = new Project();
        try{
            conexion = new ConnectionDataBase();
            String querygetProject= String.format("SELECT * FROM Project WHERE nameProject = '"+nameProject+"'");
            ResultSet resultProject = conexion.query(querygetProject).getResultSet();
            if(resultProject!=null){
                while(resultProject.next()){
                    project = new Project (resultProject.getInt("idProject"), resultProject.getString("nameProject"),resultProject.getString("description"), resultProject.getString("objetiveGeneral"),resultProject.getString("objetiveInmediate"), resultProject.getString("objetiveMediate"), resultProject.getString("methodology"), resultProject.getString("resources"), resultProject.getString("activities"), resultProject.getString("responsabilities"), resultProject.getInt("duration"), resultProject.getInt("quiantityPracticing"));
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            if(conexion!=null){
                conexion.close();
            }
        }
        return project;
    }

    @Override
    public void updateProject(Project project) {
        try{
            LinkedOrganizationDaoImpl organization = new LinkedOrganizationDaoImpl();
            organization.updateLinkedOrganization(project.getOrganization());
            LinkedOrganization linked = new LinkedOrganization();
            linked=organization.getLinkedOrganization(project.getOrganization().getName());
            
            ResponsibleProjectDaoImpl responsible  = new ResponsibleProjectDaoImpl();
            responsible.updateResponsibleProject(project.getResponsible());
            ResponsibleProject responsibleFinal = new ResponsibleProject();
            responsibleFinal = responsible.getResponsibleProject(project.getResponsible().getName());
            
            String addProject=  String.format("INSERT INTO nameProject,description,objectiveGeneral,objectiveInmediate,objectiveMediate,methodology,resources,status,duration,activities,responsabilities,quiantityPracticing,idLinkedOrganization,idResponsibleProject Project VALUES ('"+project.getNameProject()+"','"+project.getDescription()+"','"+project.getObjectiveGeneral()+"','"+project.getObjectiveImmediate()+"','"+project.getObjectiveMediate()+"','"+project.getMethodology()+"','"+project.getResources()+"','"+project.getStatus()+"',"+project.getDuration()+",'"+project.getActivities()+"','"+project.getResponsabilities()+"',"+project.getQuantityPracticing()+","+linked.getIdOrganization()+","+responsibleFinal.getIdResponsible()+")");
            ResultSet resultAddProject=null;
            resultAddProject= conexion.update(addProject).getResultSet();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            if(conexion!=null){
                conexion.close();
            }
        }
    }

    @Override
    public void deleteProject(Project project) {
    
    }
    
}
