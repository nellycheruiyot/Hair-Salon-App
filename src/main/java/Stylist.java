import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private String name;
  private String skills;
  // private static List<Stylist> instances = new ArrayList<Stylist>();
  private int id;
  // private List<Client> mClients;

  public Stylist(String name, String skills) {
    this.name = name;
    this.skills = skills;
    // instances.add(this);
    // mId = instances.size();
    // mClients = new ArrayList<Client>();
  }

  public String getName() {
    return name;
  }

  public String getSkills() {
    return skills;
  }

  public static List<Stylist> all() {
    String sql = "SELECT id, name, skills FROM stylists";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

  public int getId() {
    return id;
  }

  public static Stylist find(int id) {
  }

  public List<Client> getClients() {
  }

}
