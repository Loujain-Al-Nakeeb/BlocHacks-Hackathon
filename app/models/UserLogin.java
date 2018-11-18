package models;

import play.data.validation.Constraints;

public class UserLogin {
	@Constraints.Required private String uName;
	@Constraints.Required private String password;

	public UserLogin(@Constraints.Required String uName, @Constraints.Required String password) {
		this.uName = uName;
		this.password = password;
	}

	public String getuName() {return uName;}
	public void setuName(String uName) {this.uName = uName;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
}
