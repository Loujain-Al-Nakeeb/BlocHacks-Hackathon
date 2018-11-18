package models;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;



public class Toys extends Model {
    @Id Goods id;
    @Constraints.Required private ToysType type;

    public static Finder<Integer, Toys> find = new Finder<>(Toys.class);

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
