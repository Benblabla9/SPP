/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import classSPP.Project;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MARTHA
 */
public interface ProjectDao {
    public List<Project> getAllProjects();
    public Project getProject(String nameProject);
    public void updateProject (Project project);
    public void deleteProject (Project project);
}
