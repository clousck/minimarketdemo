package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vg_category database table.
 * 
 */
@Entity
@Table(name="vg_category")
@NamedQuery(name="VgCategory.findAll", query="SELECT v FROM VgCategory v")
public class VgCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vg_category", unique=true, nullable=false)
	private Integer idVgCategory;

	@Column(name="cat_description", length=255)
	private String catDescription;

	@Column(name="cat_name", nullable=false, length=100)
	private String catName;

	public VgCategory() {
	}

	public Integer getIdVgCategory() {
		return this.idVgCategory;
	}

	public void setIdVgCategory(Integer idVgCategory) {
		this.idVgCategory = idVgCategory;
	}

	public String getCatDescription() {
		return this.catDescription;
	}

	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}

	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

}