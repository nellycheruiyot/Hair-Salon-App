import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private String mName;
  private String mSkills;
  private static List<Stylist> instances = new ArrayList<Stylist>();
  private int mId;
  private List<Client> mClients;

  public Stylist(String name, String skills) {
    mName = name;
    mSkills = skills;
    instances.add(this);
    mId = instances.size();
    mClients = new ArrayList<Client>();
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
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public List<Client> getClients() {
    return mClients;
  }

  public void addClient(Client client) {
    mClients.add(client);
  }

}
