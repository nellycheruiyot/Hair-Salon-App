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

}
