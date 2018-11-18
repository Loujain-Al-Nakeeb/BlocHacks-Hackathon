package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ElectronicsType extends Electronics {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
    @Constraints.Required private String en;
    @Constraints.Required private String fr;

    public static Finder<Integer, ElectronicsType> find = new Finder<>(ElectronicsType.class);

    public ElectronicsType() {}
    public ElectronicsType(@Constraints.Required String en, @Constraints.Required String fr) {
        this.en = en;
        this.fr = fr;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getEn() {return en;}
    public void setEn(String en) {this.en = en;}
    public String getFr() {return fr;}
    public void setFr(String fr) {this.fr = fr;}
    public String get(String lang){
        if(lang.equalsIgnoreCase("english")) return getEn();
        else return getFr(); //French is the default language, if not translated to the asked language.
    }
}
