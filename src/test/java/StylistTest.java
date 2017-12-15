import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

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

}
