import java.util.ArrayList;
import java.util.List;

public class Client {
  private String mName;
  private boolean mDone;
  private static List<Client> instances = new ArrayList<Client>();
  private int mId;

  public Client(String name) {
    mName = name;
    mDone = false;
    instances.add(this);
    mId = instances.size();
  }

  public String getName() {
    return mName;
  }

  public boolean isDone() {
    return mDone;
  }

  public static List<Client> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Client find(int id) {
    return instances.get(id - 1);
  }

}
