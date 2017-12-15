import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

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
  public void all_returnsAllInstancesOfClient_true() {
    Client firstClient = new Client("Jane Doe");
    Client secondClient = new Client("Mary Smith");
    assertEquals(true, Client.all().contains(firstClient));
    assertEquals(true, Client.all().contains(secondClient));
  }

  @Test
  public void clear_emptiesAllTasksFromArrayList_0() {
    Client myClient = new Client("Jane Doe");
    Client.clear();
    assertEquals(Client.all().size(), 0);
  }

}
