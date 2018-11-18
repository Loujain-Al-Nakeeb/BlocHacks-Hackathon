package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.LinkedList;

@Entity
public class ClothingType extends Model {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@Constraints.Required private String en;
	@Constraints.Required private String fr;
	@OneToMany(mappedBy = "clothingType") LinkedList<Clothing> clothing;

	public static Finder<Integer, ClothingType> find = new Finder<>(ClothingType.class);

	public ClothingType() {}

	public ClothingType(@Constraints.Required String en, @Constraints.Required String fr) {
		this.en = en;
		this.fr = fr;
	}

	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	public String getEn() {return en;}
	public void setEn(String en) {this.en = en;}
	public String getFr() {return fr;}
	public void setFr(String fr) {this.fr = fr;}
	public String get(String lang) {
		if (lang.equalsIgnoreCase("english")) return getEn();
		else return getFr(); //French is the default language, if not translated to the asked language.
	}
}
