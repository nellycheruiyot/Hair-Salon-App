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
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists where id=:id";
      Stylist stylist = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }

  public List<Client> getClients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where stylistId=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Client.class);
    }
  }

  @Override
  public boolean equals(Object otherStylist) {
    if (!(otherStylist instanceof Stylist)) {
      return false;
    }else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getName().equals(newStylist.getName()) &&
             this.getSkills().equals(newStylist.getSkills()) &&
             this.getId() == newStylist.getId();
            //  this.getStylistId() == newClient.getStylistId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists (name, skills) VALUES (:name, :skills)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("skills", this.skills)
        .executeUpdate()
        .getKey();
    }
  }

  public void updateName(String name) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE stylists SET name = :name WHERE id = :id";
      con.createQuery(sql)
        .addParameter("name", name)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void updateSkills(String skills) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE stylists SET skills = :skills WHERE id = :id";
      con.createQuery(sql)
        .addParameter("skills", skills)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM stylists WHERE id = :id;";
      String sql2 = "DELETE FROM clients WHERE stylistId = :id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
      con.createQuery(sql2)
        .addParameter("id", Client.find(id).getStylistId())
        .executeUpdate();
    }
  }

}
