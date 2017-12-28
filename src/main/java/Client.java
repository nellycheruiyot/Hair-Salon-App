import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Client {
  private String name;
  private boolean done;
  // private static List<Client> instances = new ArrayList<Client>();
  private int id;
  private int stylistId;


  public Client(String name, int stylistId) {
    this.name = name;
    done = false;
    // instances.add(this);
    // mId = instances.size();
    this.stylistId = stylistId;
  }

  public String getName() {
    return name;
  }

  public boolean isDone() {
    return done;
  }

  public static List<Client> all() {
    // return instances;
    String sql = "SELECT id, name, stylistId FROM clients";
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

  public int getStylistId() {
    return stylistId;
  }

  public static Client find(int id) {
    // return instances.get(id - 1);
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where id=:id";
      Client client = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return client;
    }
  }

  @Override
  public boolean equals(Object otherClient) {
    if (!(otherClient instanceof Client)) {
      return false;
    }else {
      Client newClient = (Client) otherClient;
      return this.getName().equals(newClient.getName()) &&
             this.getId() == newClient.getId() &&
             this.getStylistId() == newClient.getStylistId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name, stylistId) VALUES (:name, :stylistId)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("stylistId", this.stylistId)
        .executeUpdate()
        .getKey();
    }
  }

}
