package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;

@Entity
public class Goods extends Model {
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)	private Integer id;
	@OneToOne(mappedBy = "id") private Food food;
	@OneToOne(mappedBy = "id") private Appliances appliances;
	@OneToOne(mappedBy = "id") private Furniture furniture;
	@OneToOne(mappedBy = "id") private Toys toys;
	@OneToOne(mappedBy = "id") private Electronics electronics;
	@OneToOne(mappedBy = "id") private Supplies supplies;
	@OneToOne(mappedBy = "id") private Clothing clothing;

	public static Finder<Integer, Goods> find = new Finder<>(Goods.class);

	public Goods() {}

	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
}
