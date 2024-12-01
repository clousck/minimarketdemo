package minimarketdemo.controller.videojuego;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.Category;
import minimarketdemo.model.core.entities.Videogame;
import minimarketdemo.model.videojuegos.managers.ManagerVideojuegos;

@Named
@SessionScoped
public class BeanVideoJuego implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerVideojuegos mVideogames;
	
	private List<Category> listaCategorias;
	private List<Videogame> listaVideojuegos;
	
	private Videogame nuevoVideojuego;
	private Videogame edicionVideojuego;

	private Category nuevaCategoria;
	
	private int idCategoria;
	
	@PostConstruct
	public void inicializar() {
		nuevaCategoria = new Category();
		nuevoVideojuego = new Videogame();
	}
	
	public BeanVideoJuego() {}
	
	public String actionCargarMenuVidejuegos() {
		listaVideojuegos = mVideogames.findAllVideojuegos();
		listaCategorias = mVideogames.findAllCategorias();
		return "videojuegos";
	}
	
	public void actionListenerInsertarVideojuego() {
		try {
			mVideogames.insertarVideojuego(nuevoVideojuego, idCategoria);
			listaVideojuegos=mVideogames.findAllVideojuegos();
			JSFUtil.crearMensajeINFO("Videojuego registrado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void actionListenerEliminarVideojuego(int id) {
		try {
			mVideogames.eliminarVideojuego(id);
			listaVideojuegos=mVideogames.findAllVideojuegos();
			JSFUtil.crearMensajeINFO("Videojuego eliminado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void actionListenerActualizarVideojuego() {
		try {
			mVideogames.actualizarVideojuego(edicionVideojuego);
			listaVideojuegos=mVideogames.findAllVideojuegos();
			JSFUtil.crearMensajeINFO("Videojuego actualizado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void actionListenerCargarVideojuego(Videogame videojuego) {
		edicionVideojuego = videojuego;
	}
	
	public List<Category> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<Category> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public List<Videogame> getListaVideojuegos() {
		return listaVideojuegos;
	}

	public void setListaVideojuegos(List<Videogame> listaVideojuegos) {
		this.listaVideojuegos = listaVideojuegos;
	}

	public int getIdCategory() {
		return idCategoria;
	}

	public void setIdCategory(int idCategory) {
		this.idCategoria = idCategory;
	}	
	

	public Videogame getNuevoVideojuego() {
		return nuevoVideojuego;
	}

	public void setNuevoVideojuego(Videogame nuevoVideojuego) {
		this.nuevoVideojuego = nuevoVideojuego;
	}

	public Category getNuevaCategoria() {
		return nuevaCategoria;
	}

	public void setNuevaCategoria(Category nuevaCategoria) {
		this.nuevaCategoria = nuevaCategoria;
	}
	public Videogame getEdicionVideojuego() {
		return edicionVideojuego;
	}

	public void setEdicionVideojuego(Videogame edicionVideojuego) {
		this.edicionVideojuego = edicionVideojuego;
	}
}
