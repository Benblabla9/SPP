package interfaces;
import classSPP.Coordinator;
import java.sql.SQLException;

public interface CoordinatorDao {
   public Coordinator getCoordinator (int staffnumber) throws SQLException;
   public void updateCoordinator (int staffnumber, Coordinator coordinator) throws SQLException;
   public String deleteCoordinator (int staffnumber, Coordinator coordinator) throws SQLException;
   public String addCoordinator (Coordinator coordinator) throws SQLException;
}