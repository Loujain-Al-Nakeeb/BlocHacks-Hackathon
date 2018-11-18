package controllers;

import models.User;
import models.UserLogin;
import play.data.Form;
import play.data.FormFactory;
import play.db.ebean.Transactional;
import play.mvc.*;

import views.html.*;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
	private FormFactory formFactory;

	@Inject public HomeController(FormFactory f) {this.formFactory = f;}

	/**
	 * An action that renders an HTML page with a welcome message.
	 * The configuration in the <code>routes</code> file means that
	 * this method will be called when the application receives a
	 * <code>GET</code> request with a path of <code>/</code>.
	 */
	public Result index() {
        return ok(index.render("Your new application is ready."));
    }

	public Result setLanguage(String language){
		session("language", language);
		return home(language);
	}

    public Result home(String language){return ok(home.render());}
    public Result home(){
		String language = session().get("language");
		if(language==null) language = "french";
		return home(language);
    }

	@Transactional
	public Result login() {
		Form<UserLogin> userForm = formFactory.form(UserLogin.class).bindFromRequest();
		if (userForm.hasErrors()) {
			return badRequest(index.render(session().get("language"), userForm));
		}
		UserLogin ul = userForm.get();
		//check userName exists
		User user = User.find.byId(ul.getuName());
		if ((user!=null) && (user.checkPassword(ul.getPassword()))) {
			session("user", user.getuName());
			return ok(home.render());
		} else {
			flash("failure", "userName and password do not match database");
			return badRequest(index.render(session().get("language"), userForm));
		}
	}

	@Transactional
	public Result logout() {
		session().clear();
		return redirect(controllers.routes.HomeController.index());
	}
}
