/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import classSPP.ResponsibleProject;

/**
 *
 * @author MARTHA
 */
public interface ResponsibleProjectDao {
    public ResponsibleProject getResponsibleProject (String email);
    public void updateResponsibleProject (ResponsibleProject responsible);
}
