public class Member {
  private int mMemberId;
  private String mMemberName;
  private int mMemberAge;
  private String mMemberDescription;

  public Member(int memberId, String memberName, int memberAge, String description) {
    mMemberId = memberId;
    mMemberName = memberName;
    mMemberAge = memberAge;
    mMemberDescription = description;
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

}
