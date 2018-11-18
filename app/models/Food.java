package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;

@Entity
public class Food extends Model {
	@Id private Goods id;
	@Constraints.Required private String en;
	@Constraints.Required private String fr;

	public static Finder<Integer, Food> find = new Finder<>(Food.class);

	public Food() {}

	public Food(@Constraints.Required String en, @Constraints.Required String fr) {
		this.en = en;
		this.fr = fr;
	}

	public Integer getId() {return id.getId();}
	public void setId(Integer id) {
		Goods goods = Goods.find.byId(id);
		if (goods != null) this.id = goods;
	}
	public String getEn() {return en;}
	public void setEn(String en) {this.en = en;}
	public String getFr() {return fr;}
	public void setFr(String fr) {this.fr = fr;}
	public String get(String lang) {
		if (lang.equalsIgnoreCase("english")) return getEn();
		else return getFr(); //French is the default language, if not translated to the asked language.
	}
}
