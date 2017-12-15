import java.util.ArrayList;
import java.util.List;

public class Client {
  private String name;
  private boolean done;
  // private static List<Client> instances = new ArrayList<Client>();
  private int id;

  public Client(String name) {
    this.name = name;
    done = false;
    // instances.add(this);
    // mId = instances.size();
  }

  public String getName() {
    return name;
  }

  public boolean isDone() {
    return done;
  }

  // public static List<Client> all() {
  //   return instances;
  // }

  // public static void clear() {
  //   instances.clear();
  // }

  public int getId() {
    return id;
  }

  public static Client find(int id) {
    // return instances.get(id - 1);
  }

}
