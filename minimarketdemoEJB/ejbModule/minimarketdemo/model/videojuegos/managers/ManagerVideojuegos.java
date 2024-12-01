package minimarketdemo.model.videojuegos.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.ThmCargo;
import minimarketdemo.model.core.entities.VgGame;
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
        // TODO Auto-generated constructor stub
    	
    }
    
    @SuppressWarnings("unchecked")
	public List<VgGame> findAllVideojuegos(){
    	return mDAO.findAll(VgGame.class, "vg_game_name");
    }
}
