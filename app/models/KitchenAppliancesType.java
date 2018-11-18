package models;

import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KitchenAppliancesType extends Model {
    @Id private int id;
    @Constraints.Required String en;
    @Constraints.Required String fr;
}