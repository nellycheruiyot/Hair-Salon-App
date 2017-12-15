import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private String mName;
  private String mSkills;

  public Stylist(String name, String skills) {
    mName = name;
    mSkills = skills;
  }

  public String getName() {
    return mName;
  }

  public String getSkills() {
    return mSkills;
  }
}
