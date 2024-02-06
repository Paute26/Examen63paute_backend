package ec.edu.ups.ppw63.examen63paute.services;

import java.util.List;

import ec.edu.ups.ppw63.examen63paute.business.GestionRecargas;
import ec.edu.ups.ppw63.examen63paute.model.Recarga;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("recargas")
public class RecargaServices {
	
	@Inject
	private GestionRecargas gRecargas;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Recarga recarga) {
		try {
			gRecargas.guardarRecargas(recarga);
			ErrorMessage error = new ErrorMessage(1, "Ok");
			return Response.status(Response.Status.CREATED)
					.entity(error).build();
		} catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
		
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Recarga ord) {
		try {
			gRecargas.actualizarOrden(ord);
			return Response.ok(ord).build();
		} catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String borrar(@QueryParam("id") int codigo) {
		try {
			gRecargas.borrarOrden(codigo);
			return "Ok";
		} catch (Exception e) {
			return "Error";
		}
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("application/json")
	public Response getOrdenById(@QueryParam("codigo") int codigo) {
		try{
			System.out.println("cedula " + codigo);
			Recarga ord = gRecargas.getOrdenPorId(codigo);
			return Response.ok(ord).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Cliente no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getClientes(){
		List<Recarga> ordenes = gRecargas.getOrdenes();
		if(ordenes.size()>0)
			return Response.ok(ordenes).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran pedidos");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
}

