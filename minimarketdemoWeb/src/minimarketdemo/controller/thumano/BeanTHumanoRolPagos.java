package minimarketdemo.controller.thumano;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.SegUsuario;
import minimarketdemo.model.core.entities.ThmCargo;
import minimarketdemo.model.core.entities.ThmEmpleado;
import minimarketdemo.model.core.entities.ThmPeriodoRol;
import minimarketdemo.model.core.entities.ThmRolCabecera;
import minimarketdemo.model.seguridades.managers.ManagerSeguridades;
import minimarketdemo.model.thumano.managers.ManagerTHumano;

@Named
@SessionScoped
public class BeanTHumanoRolPagos implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerTHumano mTHumano;
	@EJB
	private ManagerSeguridades mSeguridades;
	private List<ThmPeriodoRol> listaPeriodosRol;
	private List<ThmRolCabecera> listaRolCabeceras;
	private int periodoRolSeleccionado;
	
	
	@PostConstruct
	public void inicializar() {

	}

	public BeanTHumanoRolPagos() {
		
	}
	
	public String actionCargarMenuRoles() {
		listaRolCabeceras=mTHumano.findAllThmRolCabecera();
		listaPeriodosRol=mTHumano.findAllThmPeriodoRol();
		return "roles?faces-redirect=true";
	}
	
	public void actionListenerGenerarRolPagos() {
		try {
			mTHumano.generarRolPagos(periodoRolSeleccionado);
			listaRolCabeceras=mTHumano.findAllThmRolCabecera();
			JSFUtil.crearMensajeINFO("Rol generado exitosamente.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<ThmPeriodoRol> getListaPeriodosRol() {
		return listaPeriodosRol;
	}

	public void setListaPeriodosRol(List<ThmPeriodoRol> listaPeriodosRol) {
		this.listaPeriodosRol = listaPeriodosRol;
	}

	public List<ThmRolCabecera> getListaRolCabeceras() {
		return listaRolCabeceras;
	}

	public void setListaRolCabeceras(List<ThmRolCabecera> listaRolCabeceras) {
		this.listaRolCabeceras = listaRolCabeceras;
	}

	public int getPeriodoRolSeleccionado() {
		return periodoRolSeleccionado;
	}

	public void setPeriodoRolSeleccionado(int periodoRolSeleccionado) {
		this.periodoRolSeleccionado = periodoRolSeleccionado;
	}
	
	

}
