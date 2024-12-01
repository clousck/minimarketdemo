package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vg_game database table.
 * 
 */
@Entity
@Table(name="vg_game")
@NamedQuery(name="VgGame.findAll", query="SELECT v FROM VgGame v")
public class VgGame implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vg_game", unique=true, nullable=false)
	private Integer idVgGame;

	@Column(name="game_name", nullable=false, length=100)
	private String gameName;

	@Column(name="id_vg_category", nullable=false)
	private Integer idVgCategory;

	@Column(name="id_vg_developer", nullable=false)
	private Integer idVgDeveloper;

	@Column(name="publication_year", nullable=false)
	private Integer publicationYear;

	public VgGame() {
	}

	public Integer getIdVgGame() {
		return this.idVgGame;
	}

	public void setIdVgGame(Integer idVgGame) {
		this.idVgGame = idVgGame;
	}

	public String getGameName() {
		return this.gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Integer getIdVgCategory() {
		return this.idVgCategory;
	}

	public void setIdVgCategory(Integer idVgCategory) {
		this.idVgCategory = idVgCategory;
	}

	public Integer getIdVgDeveloper() {
		return this.idVgDeveloper;
	}

	public void setIdVgDeveloper(Integer idVgDeveloper) {
		this.idVgDeveloper = idVgDeveloper;
	}

	public Integer getPublicationYear() {
		return this.publicationYear;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}

}