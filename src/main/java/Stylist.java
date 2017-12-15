import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private String mName;
  private String mSkills;
  private static List<Stylist> instances = new ArrayList<Stylist>();
  private int mId;

  public Stylist(String name, String skills) {
    mName = name;
    mSkills = skills;
    instances.add(this);
    mId = instances.size();
  }

  public String getName() {
    return mName;
  }

  public String getSkills() {
    return mSkills;
  }

  public static List<Stylist> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Stylist find(int id) {
    return instances.get(id - 1);
  }
}
