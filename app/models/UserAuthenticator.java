package models;

import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

import static play.mvc.Controller.flash;

public class UserAuthenticator extends Security.Authenticator {
	@Override
	public String getUsername(Http.Context ctx) {
		String userName = ctx.session().get("user");
		return userName;
	}

	@Override
	public Result onUnauthorized(Http.Context ctx) {
		flash("failure", "you are not logged in or your session timed out");
		return redirect(controllers.routes.HomeController.index());
	}
}