import java.util.ArrayList;
import java.util.List;

public class Client {
  private String name;
  private boolean done;
  // private static List<Client> instances = new ArrayList<Client>();
  private int id;
  private int categoryId;


  public Client(String name, int categoryId) {
    this.name = name;
    done = false;
    // instances.add(this);
    // mId = instances.size();
    this.categoryId = categoryId;
  }

  public String getName() {
    return name;
  }

  public boolean isDone() {
    return done;
  }

  public static List<Client> all() {
    // return instances;
    String sql = "SELECT id, name, categoryId FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  // public static void clear() {
  //   instances.clear();
  // }

  public int getId() {
    return id;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public static Client find(int id) {
    // return instances.get(id - 1);
  }

  @Override
  public boolean equals(Object otherClient) {
    if (!(otherClient instanceof Client)) {
      return false;
    }else {
      Task newClient = (Client) otherClient;
      return this.getName().equals(newClient.getName()) &&
             this.getId() == newClient.getId() &&
             this.getCategoryId() == newClient.getCategoryId();
    }
  }

}
