import java.util.HashMap;
import java.util.Map;
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

    post("/members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String id = request.queryParams("id");
      Integer userInputId = Integer.parseInt(id);
      String userInputName = request.queryParams("name");
      String age = request.queryParams("age");
      Integer userInputAge = Integer.parseInt(age);
      String userInputDescription = request.queryParams("description");
      Member newMember = new Member(userInputId, userInputName, userInputAge, userInputDescription);

      // newMember.add(mMemberId);
      // newMember.add(mMemberName);
      // newMember.add(mMemberAge);
      // newMember.add(mMemberDescription);
      request.session().attribute("member", newMember);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
