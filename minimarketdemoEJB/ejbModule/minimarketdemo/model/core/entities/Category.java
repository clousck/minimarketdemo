package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=2147483647)
	private String description;

	@Column(nullable=false, length=255)
	private String name;

	//bi-directional many-to-one association to Videogame
	@OneToMany(mappedBy="category")
	private List<Videogame> videogames;

	public Category() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Videogame> getVideogames() {
		return this.videogames;
	}

	public void setVideogames(List<Videogame> videogames) {
		this.videogames = videogames;
	}

	public Videogame addVideogame(Videogame videogame) {
		getVideogames().add(videogame);
		videogame.setCategory(this);

		return videogame;
	}

	public Videogame removeVideogame(Videogame videogame) {
		getVideogames().remove(videogame);
		videogame.setCategory(null);

		return videogame;
	}

}