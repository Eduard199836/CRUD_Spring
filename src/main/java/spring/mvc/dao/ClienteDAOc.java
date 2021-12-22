package spring.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.controlador.entity.Cliente;

@Repository
public class ClienteDAOc implements ClienteDAO {

	@Override
	@Transactional
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		
		//Obtener la session
		Session miSession=sessionFactory.getCurrentSession();
		
		//Crear la consulta (Query)
		Query<Cliente> miQuery=miSession.createQuery("from Cliente",Cliente.class); 
		
		//Ejecutar la query y devolver resultados
		List<Cliente> clientes=miQuery.getResultList();
		
		return clientes;
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void insertarCliente(Cliente elCliente) {
		
		//Obtener la session
		Session miSession=sessionFactory.getCurrentSession();
		
		//Insertar cliente
		//miSession.save(elCliente);
		miSession.saveOrUpdate(elCliente);
		
	}

	@Override
	@Transactional
	public Cliente getCliente(int id) {
		
		//Obtener la sesion
		Session miSession=sessionFactory.getCurrentSession();
		
		//Obtener la informacion del cliente seleccionado
		Cliente elCliente=miSession.get(Cliente.class, id);
		
		return elCliente;
	}

	@Override
	@Transactional
	public void eliminarCliente(int id) {
		
		//Obtener la sesion
		Session miSession=sessionFactory.getCurrentSession();
				
		//Borrar cliente usando su Id
		Query consulta=miSession.createQuery("delete from Cliente where id=:Idcliente");
		
		consulta.setParameter("Idcliente", id);
		
		consulta.executeUpdate();
	} 
	
	
	
}
