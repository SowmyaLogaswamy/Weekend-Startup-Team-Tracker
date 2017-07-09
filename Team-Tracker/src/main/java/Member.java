import java.util.ArrayList;
public class Member {
  private int mMemberId;
  private String mMemberName;
  private int mMemberAge;
  private String mMemberDescription;
  // private static ArrayList<Member> instances = new ArrayList<Member>();
  // private int mId;

  public Member(int memberId, String memberName, int memberAge, String description) {
    mMemberId = memberId;
    mMemberName = memberName;
    mMemberAge = memberAge;
    mMemberDescription = description;
    //  instances.add(this);
    // mId = instances.size();
  }

  public int getMemberId() {
    return mMemberId;
  }
  public String getMemberName() {
    return mMemberName;
  }
  public int getMemberAge() {
    return mMemberAge;
  }
  public String getDescription() {
    return mMemberDescription;
  }
  //  public static ArrayList<Member> all() {
  //    return instances;
  //  }
  // public static void clear(); {
  //     instances.clear();
  // }
//   public int getId() {
//     return mId;
//   }
 // public static Member find(int id) {
 //  return instances.get(id - 1);
 // }

}
