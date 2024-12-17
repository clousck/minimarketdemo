package minimarketdemo.controller.eventos;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemoFactEJB.VwEvento;
import minimarketdemoFactEJB.model.eventos.managers.ManagerEventos;
@Named
@SessionScoped
public class BeanEventos implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerEventos mEventos;
	
	private List<VwEvento> listaEventos;
	
	public List<VwEvento> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<VwEvento> listaEventos) {
		this.listaEventos = listaEventos;
	}

	public String actionCargarMenuEventos() {
		listaEventos = mEventos.findAllEventos();
		return "eventos";
	}
	
	
}
