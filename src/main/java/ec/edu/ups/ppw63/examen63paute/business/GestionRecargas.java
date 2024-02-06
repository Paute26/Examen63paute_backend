package ec.edu.ups.ppw63.examen63paute.business;

import java.util.List;

import ec.edu.ups.ppw63.examen63paute.dao.RecargaDAO;
import ec.edu.ups.ppw63.examen63paute.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionRecargas {
	
	@Inject
	private RecargaDAO daoRecarga;
	
	public void guardarRecargas(Recarga recarga) {
		Recarga cli = daoRecarga.read(recarga.getCodigo());
		if(cli != null) {
			daoRecarga.update(recarga);
		} else {
			daoRecarga.insert(recarga); 
		}
	}
	
	public void actualizarOrden(Recarga recarga) throws Exception {
		Recarga cli = daoRecarga.read(recarga.getCodigo());
		if (cli != null){
			daoRecarga.update(recarga);
		}else {
			throw new Exception("Pedido Inexistente...");
		}
	}
	
	
	
	public Recarga getOrdenPorNumero(String numero) throws Exception {
		if(numero.length() < 13) 
			throw new Exception("Cedula Incorrecta");
		return daoRecarga.getOrdenPorNumero(numero);
	}
	
	public Recarga getOrdenPorId(int codigo) throws Exception {
		if(codigo < 0) 
			throw new Exception("Id Incorrecto");
		return daoRecarga.getOrdenPorId(codigo);
	}
	
	public void borrarOrden(int codigo) {
		daoRecarga.remove(codigo); 
	}
	
	public List<Recarga> getOrdenes() {
		return daoRecarga.getAll();
	}

}
