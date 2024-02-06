package ec.edu.ups.ppw63.examen63paute.dao;


import java.util.List;

import ec.edu.ups.ppw63.examen63paute.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class RecargaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Recarga user) {
		em.persist(user);
	}
	
	public void update(Recarga user) {
		em.merge(user);
	}
	
	public void remove(int codigo) {
		Recarga user = em.find(Recarga.class, codigo);
		em.remove(user);
	}
	
	public Recarga read(int codigo) {
		Recarga user = em.find(Recarga.class, codigo);
		return user;
	}
	
	public List<Recarga> getAll() {
		String jpql = "SELECT r FROM Recarga r";
		Query q = em.createQuery(jpql, Recarga.class);
		return q.getResultList();
	}
		
	public Recarga getOrdenPorId(int codigo) {
		String jpql = "SELECT r FROM Recarga r WHERE r.codigo = :codigo";
		Query q = em.createQuery(jpql, Recarga.class);
		q.setParameter("codigo", codigo);
		List<Recarga> user = q.getResultList();
		if(user.size()>0)
			return user.get(0);
		return null;
	}
	public Recarga getOrdenPorNumero(String numero) {
		String jpql = "SELECT r FROM Recarga r WHERE r.numero = :numero";
		Query q = em.createQuery(jpql, Recarga.class);
		q.setParameter("numero", numero);
		List<Recarga> orden = q.getResultList();
		if(orden.size()>0)
			return orden.get(0);
		return null;
	}
	
}
