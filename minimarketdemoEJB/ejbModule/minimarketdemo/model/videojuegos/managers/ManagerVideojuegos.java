package minimarketdemo.model.videojuegos.managers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.Category;
import minimarketdemo.model.core.entities.Videogame;
import minimarketdemo.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerVideojuegos
 */
@Stateless
@LocalBean
public class ManagerVideojuegos {
	@EJB
	private ManagerDAO mDAO;
    /**
     * Default constructor. 
     */
    public ManagerVideojuegos() {
    	
    }
    
    @SuppressWarnings("unchecked")
	public List<Videogame> findAllVideojuegos(){
    	return mDAO.findAll(Videogame.class);
    }
    
    @SuppressWarnings("unchecked")
	public List<Category> findAllCategorias(){
    	return mDAO.findAll(Category.class);
    }
    
    // Obtener un videojuego por ID
    public Videogame findVideojuegoById(int idVideogame) throws Exception {
        return (Videogame) mDAO.findById(Videogame.class, idVideogame);
    }
    
    public Videogame insertarVideojuego(Videogame videojuego, int idCategory) throws Exception {
    	try {
    		videojuego.setCategory((Category)mDAO.findById(Category.class, idCategory));
        	mDAO.insertar(videojuego);
        	return videojuego;
        } catch (Exception e) {
            throw new Exception("Error al insertar el videojuego: " + e.getMessage());
        }
    }
    
 // Método para actualizar un tipo de instrumento existente
    public Videogame actualizarVideojuego(Videogame nuevoVideojuego) throws Exception {
        try {
            mDAO.actualizar(nuevoVideojuego);
            return nuevoVideojuego;
        } catch (Exception e) {
            throw new Exception("Error al actualizar el videojuego: " + e.getMessage());
        }
    }
    
 // Método para eliminar un tipo de instrumento por ID
    public void eliminarVideojuego(Integer id) throws Exception {
        try {
            Videogame videojuego = (Videogame)mDAO.findById(Videogame.class, id);
            if (videojuego != null) {
                mDAO.eliminar(Videogame.class, id);
            } else {
                throw new Exception("La categoría aún contiene videjuegos");
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar el videojuego: " + e.getMessage());
        }
    }
}
