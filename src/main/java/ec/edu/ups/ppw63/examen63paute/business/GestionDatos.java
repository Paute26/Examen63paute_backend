package ec.edu.ups.ppw63.examen63paute.business;


import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw63.examen63paute.dao.RecargaDAO;
import ec.edu.ups.ppw63.examen63paute.model.Recarga;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
	
	@Inject
	private RecargaDAO recargaDAO;
	
	
	@PostConstruct
	public void init() {
		System.out.println("Iniciando");
		
		Recarga orden = new Recarga();
		orden.setCodigo(1);
		orden.setNumero("+593 87654321");
		orden.setOperadora("Claro");
		orden.setMonto("20");
		
		recargaDAO.insert(orden); 
		
		orden = new Recarga();
		orden.setCodigo(2);
		orden.setNumero("0987654321");
		orden.setOperadora("Movi");
		orden.setMonto("10");
		
		recargaDAO.insert(orden);
		
				
		System.out.println("\n------------- Facturas2");
		List<Recarga> list2 = recargaDAO.getAll();
		for(Recarga fact: list2) {
			System.out.println(fact);
		}
		
	}
	
}


