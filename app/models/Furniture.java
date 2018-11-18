package models;

import io.ebean.Finder;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.File;

@Entity
public class Furniture extends Goods {
   @Id private Goods id;
   @Constraints.Required  private FurnitureType type;
   private String size;
   private Material material;
   private Colour colour;
   private File picture;
   @Constraints.Required private String en;
   @Constraints.Required private String fr;

   public static Finder<Integer, Furniture> find = new Finder<>(Furniture.class);

   public Furniture() {}

   public Furniture(@Constraints.Required String en, @Constraints.Required String fr) {
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
