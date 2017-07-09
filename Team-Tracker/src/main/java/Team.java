import java.util.ArrayList;
public class Team {
  private int mTeamId;
  private String mTeamName;
  private String mTeamDescription;
  private ArrayList<Member> mMembers;

public Team(int teamId, String teamName, String teamDescription) {
  mTeamId = teamId;
  mTeamName = teamName;
  mTeamDescription = teamDescription;
  mMembers = new ArrayList<Member>();
}

public int getTeamId() {
  return mTeamId;
}

public String getDescription() {
  return mTeamName;
}

public String getTeamName() {
  return mTeamDescription;
}

public ArrayList<Member> getMembers() {
  return mMembers;
}

public void addMember(Member member) {
  mMembers.add(member);
}
}
