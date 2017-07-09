import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object>model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    get("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/indexteam.vtl");
      model.put("teams", request.session().attribute("teams"));
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    post("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Integer userInputId = Integer.parseInt(request.queryParams("id"));
      String userInputName = request.queryParams("teamname");
      String userInputDescription = request.queryParams("details");
      Team newteam = new Team(userInputId, userInputName, userInputDescription);

      ArrayList<Team> teams = request.session().attribute("teams");
      if(teams == null)
      {
          teams = new ArrayList<Team>();
          request.session().attribute("teams", teams);
      }

      teams.add(newteam);
      model.put("template", "templates/indexteam.vtl");
      model.put("teams", request.session().attribute("teams"));
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    get("/members", (request, response) -> {
      Map<String, Object>model = new HashMap<String, Object>();
      model.put("members", request.session().attribute("members"));
      model.put("template", "templates/indexmembers.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    post("/members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<Member> members = request.session().attribute("members");
      if(members == null) {
        members = new ArrayList<Member>();
        request.session().attribute("members", members);
      }
      String id = request.queryParams("id");
      Integer userInputId = Integer.parseInt(id);
      String userInputName = request.queryParams("name");
      String age = request.queryParams("age");
      Integer userInputAge = Integer.parseInt(age);
      String userInputDescription = request.queryParams("description");
      Member newMember = new Member(userInputId, userInputName, userInputAge, userInputDescription);
      members.add(newMember);
      // newMember.add(mMemberId);
      // newMember.add(mMemberName);
      // newMember.add(mMemberAge);
      // newMember.add(mMemberDescription);
      //request.session().attribute("member", newMember);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/members/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String id = request.params(":id");
      Integer userInputId = Integer.parseInt(id);
      ArrayList<Member> members = request.session().attribute("members");
      for(Member member: members)
      {
        if(member.getMemberId() == userInputId) {
          model.put("member", member);
        }
      }
      return new ModelAndView(model, "templates/member.vtl");
    }, new VelocityTemplateEngine());

    get("/teams/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String id = request.params(":id");
      Integer userInputId = Integer.parseInt(id);
      ArrayList<Team> teams = request.session().attribute("teams");
      for(Team team: teams) {
        if(team.getTeamId() == userInputId) {
          model.put("team", team);
        }
      }
      return new ModelAndView(model, "templates/member.vtl");
    }, new VelocityTemplateEngine());
  }
}
