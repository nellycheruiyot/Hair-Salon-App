import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

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
  public void Client_instantiatesCorrectly_true() {
    Client myClient = new Client("Jane Doe", 1);
    assertEquals(true, myClient instanceof Client);
  }

  @Test
  public void Client_instantiatesWithName_String() {
    Client myClient = new Client("Jane Doe", 1);
    assertEquals("Jane Doe", myClient.getName());
  }

  @Test
  public void isDone_isFalseAfterInstantiation_false() {
    Client myClient = new Client("Jane Doe", 1);
    assertEquals(false, myClient.isDone());
  }

  @Test
  public void all_returnsAllInstancesOfClient_true() {
    Client firstClient = new Client("Jane Doe", 1);
    firstClient.save();
    Client secondClient = new Client("Mary Smith", 2);
    secondClient.save();
    assertEquals(true, Client.all().get(0).equals(firstClient));
    assertEquals(true, Client.all().get(1).equals(secondClient));
  }

  @Test
  public void clear_emptiesAllClientsFromArrayList_0() {
    Client myClient = new Client("Jane Doe", 1);
    assertEquals(Client.all().size(), 0);
  }

  @Test
  public void getId_clientsInstantiatesWithAnID() {
    Client myClient = new Client("Jane Doe", 1);
    myClient.save();
    assertTrue(myClient.getId() > 0);
  }

  @Test
  public void find_returnsClientWithSameId_secondClient() {
    // Client.clear();
    Client firstClient = new Client("Jane Doe", 1);
    firstClient.save();
    Client secondClient = new Client("Mary Smith", 2);
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }

  @Test
  public void equals_returnsTrueIfDescriptionsAretheSame() {
    Client firstClient = new Client("Jane Doe", 1);
    Client secondClient = new Client("Jane Doe", 1);
    assertTrue(firstClient.equals(secondClient));
  }

  @Test
  public void save_returnsTrueIfDescriptionsAretheSame() {
    Client myClient = new Client("Jane Doe", 1);
    myClient.save();
    assertTrue(Client.all().get(0).equals(myClient));
  }

  @Test
  public void save_assignsIdToObject() {
    Client myClient = new Client("Jane Doe", 1);
    myClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(myClient.getId(), savedClient.getId());
  }

  @Test
  public void update_updatesClientName_true() {
    Client myClient = new Client("Jane Doe", 1);
    myClient.save();
    myClient.update("Lilian Mwangi");
    assertEquals("Lilian Mwangi", Client.find(myClient.getId()).getName());
  }

}
