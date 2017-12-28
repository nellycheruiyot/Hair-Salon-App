import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteClientsQuery = "DELETE FROM clients *;";
      String deleteStylistsQuery = "DELETE FROM stylists *;";
      con.createQuery(deleteClientsQuery).executeUpdate();
      con.createQuery(deleteStylistsQuery).executeUpdate();
    }
  }

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("June","Braids");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_instantiatesWithName_String() {
    Stylist testStylist = new Stylist("June","Braids");
    assertEquals("June", testStylist.getName());
  }

  @Test
  public void getSkills_instantiatesWithSkill_String() {
    Stylist testStylist = new Stylist("June","Braids");
    assertEquals("Braids", testStylist.getSkills());
  }

  @Test
  public void all_returnsAllInstancesOfStylist_true() {
    Stylist firstStylist = new Stylist("June","Braids");
    Stylist secondStylist = new Stylist("Lilian","Weave");
    assertEquals(true, Stylist.all().contains(firstStylist));
    assertEquals(true, Stylist.all().contains(secondStylist));
  }

  @Test
  public void clear_emptiesAllStylistsFromList_0() {
    Stylist testStylist = new Stylist("June","Braids");
    // Stylist.clear();
    assertEquals(Stylist.all().size(), 0);
  }

  @Test
  public void getId_stylistsInstantiateWithAnId_1() {
    // Stylist.clear();
    Stylist testStylist = new Stylist("June","Braids");
    assertEquals(1, testStylist.getId());
  }

  @Test
  public void find_returnsStylistWithSameId_secondStylist() {
    // Stylist.clear();
    Stylist firstStylist = new Stylist("June","Braids");
    Stylist secondStylist = new Stylist("Lilian","Weave");
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }

  @Test
  public void getClients_initiallyReturnsEmptyList_ArrayList() {
    // Stylist.clear();
    Stylist testStylist = new Stylist("June","Braids");
    assertEquals(0, testStylist.getClients().size());
  }

  @Test
  public void addClient_addsClientToList_true() {
    Stylist testStylist = new Stylist("June","Braids");
    Client testClient = new Client("Jane Doe");
    testStylist.addClient(testClient);
    assertTrue(testStylist.getClients().contains(testClient));
  }

  @Test
    public void find_returnsNullWhenNoClientFound_null() {
      assertTrue(Stylist.find(999) == null);
    }

}
