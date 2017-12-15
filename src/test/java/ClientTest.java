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
      String sql = "DELETE FROM clients *;";
      con.createQuery(sql).executeUpdate();
    }
  }

  @Test
  public void Client_instantiatesCorrectly_true() {
    Client myClient = new Client("Jane Doe");
    assertEquals(true, myClient instanceof Client);
  }

  @Test
  public void Client_instantiatesWithName_String() {
    Client myClient = new Client("Jane Doe");
    assertEquals("Jane Doe", myClient.getName());
  }

  @Test
  public void isDone_isFalseAfterInstantiation_false() {
    Client myClient = new Client("Jane Doe");
    assertEquals(false, myClient.isDone());
  }

  @Test
  public void all_returnsAllInstancesOfClient_true() {
    Client firstClient = new Client("Jane Doe");
    Client secondClient = new Client("Mary Smith");
    assertEquals(true, Client.all().contains(firstClient));
    assertEquals(true, Client.all().contains(secondClient));
  }

  @Test
  public void clear_emptiesAllClientsFromArrayList_0() {
    Client myClient = new Client("Jane Doe");
    assertEquals(Client.all().size(), 0);
  }

  @Test
  public void getId_clientsInstantiatesWithAnID_1() {
    Client myClient = new Client("Jane Doe");
    assertEquals(1, myClient.getId());
  }

  @Test
  public void find_returnsClientWithSameId_secondClient() {
    // Client.clear();
    Client firstClient = new Client("Jane Doe");
    Client secondClient = new Client("Mary Smith");
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }

  @Test
  public void equals_returnsTrueIfDescriptionsAretheSame() {
    Client firstClient = new Client("Jane Doe");
    Client secondClient = new Client("Mary Smith");
    assertTrue(firstClient.equals(secondClient));
  }

}
