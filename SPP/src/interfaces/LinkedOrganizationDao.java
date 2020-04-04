/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import classSPP.LinkedOrganization;
import java.util.List;

/**
 *
 * @author MARTHA
 */
public interface LinkedOrganizationDao {
    public List<LinkedOrganization> getAllLinkedOrganization();
    public LinkedOrganization getLinkedOrganization (String name);
    public void updateLinkedOrganization (LinkedOrganization organization);
}
