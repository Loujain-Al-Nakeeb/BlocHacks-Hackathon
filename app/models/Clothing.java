package models;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.File;

@Entity
public class Clothing extends Model {
	@Id Goods id;
	private File picture;
	private Material material;
	private Colour colour;
	@Constraints.Required private String size;
	@Constraints.Required private ClothingType type;
	private boolean isWinter;
	private Brand brand;

	public static Finder<Integer, Clothing> find = new Finder<>(Clothing.class);

	public Integer getId() {return id.getId();}
	public void setId(Integer id) {
		Goods goods = Goods.find.byId(id);
		if (goods != null) this.id = goods;
	}
	public String getEn() {return type.getEn() + " - " + size;}
	public String getFr() {return type.getFr() + " - " + size;}
	public String get(String lang) {
		if (lang.equalsIgnoreCase("english")) return getEn();
		else return getFr(); //French is the default language, if not translated to the asked language.
	}

	public boolean isWinter() {return isWinter;}
	public void setWinter(boolean winter) {isWinter = winter;}
	public Material getMaterial() {return material;}
	public void setMaterial(Material material) {this.material = material;}
	public Colour getColour() {return colour;}
	public void setColour(Colour colour) {this.colour = colour;}
}
