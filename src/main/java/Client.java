import java.util.ArrayList;
import java.util.List;

public class Client {
  private String mName;
  private static List<Client> instances = new ArrayList<Client>();

  public Client(String name) {
    mName = name;
    instances.add(this);
  }

  public String getName() {
    return mName;
  }

  public static List<Client> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

}
