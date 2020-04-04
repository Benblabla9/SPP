package interfaces;
import classSPP.Practicing;
import java.sql.SQLException;

public interface PracticingDao {
   public Practicing getPracticing (String enrollment) throws SQLException;
   public void updatePracticing (String enrollment, Practicing practicing) throws SQLException;
   public String deletePracticing (String enrollment, Practicing practicing) throws SQLException;
   public String addPracticing (Practicing practicing) throws SQLException;
}
