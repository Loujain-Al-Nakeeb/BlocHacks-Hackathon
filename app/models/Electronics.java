package models;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.File;

@Entity
public class Electronics extends Goods {
    @Id Goods id;
    private File picture;
    private Colour colour;
    private String size;
	@Constraints.Required  private ElectronicsType type;
    private Brand brand;

	public static Finder<Integer, Electronics> find = new Finder<>(Electronics.class);

	public Integer getId() {return id.getId();}
	public void setId(Integer id) {
		Goods goods = Goods.find.byId(id);
		if (goods != null) this.id = goods;
	}
	public String getEn() {return type.getEn();}
	public String getFr() {return type.getFr();}
	public String get(String lang) {
		if (lang.equalsIgnoreCase("english")) return getEn();
		else return getFr(); //French is the default language, if not translated to the asked language.
	}

}
