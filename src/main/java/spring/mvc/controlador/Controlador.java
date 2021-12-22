package spring.mvc.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.mvc.controlador.entity.Cliente;
import spring.mvc.dao.ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	
	@RequestMapping("/lista")
	public String listaClientes(Model elModelo) {
		
		//Obtener los clientes desde el DAO
		
		List<Cliente> losClientes=clienteDAO.getClientes();
		
		//Agregar los clientes al modelo
		
		elModelo.addAttribute("clientes",losClientes);
		
		return "lista-clientes";
	}
	
	@RequestMapping("/FormularioAgregar")
	public String formularioAgregar (Model elModelo) {
		
		//Bind de datos clientes
		
		Cliente elCliente = new Cliente();
		elModelo.addAttribute("cliente",elCliente);
		
		return "formulariocliente";
	}
	
	@PostMapping("/insertarCliente")
	public String insertarCliente (@ModelAttribute("cliente") Cliente elCliente) {
		
		//Insertar cliente en base de datos
		clienteDAO.insertarCliente(elCliente);
		
		return "redirect:/cliente/lista";	
	}
	
	@GetMapping("/FormularioActualizar")
	public String FormularioActualizar(@RequestParam("clienteId") int Id, Model elModelo) {
		
		//Obtener Cliente
		Cliente elCliente=clienteDAO.getCliente(Id);
		
		//Establecer cliente como atributo del modelo
		elModelo.addAttribute("cliente",elCliente);
		
	
		//Enviar al formulario
		return "formulariocliente";
		
	}
	
	@GetMapping("/Eliminar")
	public String EliminarCliente(@RequestParam("clienteId") int Id) {
		
		//Eliminar Cliente
		clienteDAO.eliminarCliente(Id);
				
		//Redireccionar a la lista del cliente
		return "redirect:/cliente/lista";
		
	}
	
	
	@Autowired
	private ClienteDAO clienteDAO;
}
