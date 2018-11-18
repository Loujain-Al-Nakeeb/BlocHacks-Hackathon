package models;

import io.ebean.Finder;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;

@Entity
public class User {
	@Id private String uName;
	@Constraints.Required private String password;
	@Constraints.Required private String fName;
	@Constraints.Required private String lName;
	private boolean isNewcomer;
	@Constraints.Required private String email;
	private String phone;
	@Constraints.Required private String postalCode;
	@ManyToMany private ArrayList<Language> languages;

	public static Finder<String, User> find = new Finder<>(User.class);

	public User() {}
	public User(String uName, @Constraints.Required String password, @Constraints.Required String fName, @Constraints.Required String lName, boolean isNewcomer, @Constraints.Required String email, String phone, @Constraints.Required String postalCode) {
		this.uName = uName;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.isNewcomer = isNewcomer;
		this.email = email;
		this.phone = phone;
		this.postalCode = postalCode;
		languages = new ArrayList<>();
	}

	public String getuName() {return uName;}
	public void setuName(String uName) {this.uName = uName;}
	public String getfName() {return fName;}
	public void setfName(String fName) {this.fName = fName;}
	public String getlName() {return lName;}
	public void setlName(String lName) {this.lName = lName;}
	public boolean isNewcomer() {return isNewcomer;}
	public void setNewcomer(boolean newcomer) {isNewcomer = newcomer;}
	public Language[] getLanguages() {
		int size = languages.size();
		Language[] answer = new Language[size];
		for(int i = 0; i<size; i++) answer[i] = languages.get(i);
		return answer;
	}
	public void addLanguage(Language language) {if((language!=null) && (!languages.contains(language))) languages.add(language);}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public String getPostalCode() {return postalCode;}
	public void setPostalCode(String postalCode) {this.postalCode = postalCode;}
	public void setLanguages(int[] languages) {
		for(int i : languages) {
			Language language = Language.find.byId(i);
			//Only insert a language if it exists on the list of Languages
			if((language!=null) && (!this.languages.contains(language))) this.languages.add(language);
		}
	}
	public void setLanguages(ArrayList<Language> languages) {this.languages = languages;}
	public void setPassword(String password) {this.password = password;}
	public boolean checkPassword(String password) {return this.password.equals(password);}
}
