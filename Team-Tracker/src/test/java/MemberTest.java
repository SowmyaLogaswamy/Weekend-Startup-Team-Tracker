import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {

  @Test
  public void getMemberId_instantiatesWithId_01() {
    Member member = new Member(01, "Sowmya", 27, "She is a Software Professional");
    assertEquals(01, member.getMemberId());
  }
  @Test
  public void getMemberName_instantiatesWithName_Sowmya() {
    Member member = new Member(01, "Sowmya", 27, "She is a s/w professional");
    assertEquals("Sowmya", member.getMemberName());
  }
  @Test
  public void getMemberAge_instantiatesWithAge_27() {
    Member member = new Member(01, "Sowmya", 27, "She is a S/w professional");
    assertEquals(27, member.getMemberAge());
  }
  @Test
  public void getDescription_instantiatesWithDescription_String() {
    Member member = new Member(01, "Sowmya", 27, "She is a Software Professional");
    assertEquals("She is a Software Professional", member.getDescription());
  }

}
