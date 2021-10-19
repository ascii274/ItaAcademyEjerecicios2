package com.ascii274.practica.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ascii274.practica.bean.Empleat;
import com.ascii274.practica.repository.BaseDatosJDBC;

import net.bytebuddy.asm.Advice.Exit;

@Controller // lo convertimos en un servlet atiende a peticiones http
@RequestMapping("")

public class Controlador {
	Empleat empleat;
	BaseDatosJDBC bd = new BaseDatosJDBC();
	
	/**
	 * - Get: requesta data
	 * - Inicio del web le pasamos por parametro Model
	 * @param model
	 * @return
	 */
//	@CrossOrigin(origins="http://localhost:9001") 
	@GetMapping ("/")
	public String inicioBusqueda(Model model) {
		model.addAttribute("titol", "Formulari de recerca");
		model.addAttribute("titolTextRecerca",
				"Introdueix un text o Clic en buscar per continuar.");		
		return "busqueda";
		
	}
	
	/**
	 * - Post: sending data to a server
	 * @param model
	 * @param buscar
	 * @return
	 */
	
	@PostMapping("/buscar")
	public String buscar(Model model, @RequestParam String buscar) {
		int idMax=0;
		ArrayList<Empleat> empleats = new ArrayList<Empleat>();

		idMax= bd.getIdMax() + 1; // agregamos +1 al valor maximo del índice
		if(buscar !="") { // if have search			
			empleats = bd.searchJobs(buscar);
		}else {
			empleats = bd.getEmpleats();			
		}
		model.addAttribute("empleats",empleats);
//		model.addAttribute("empleat",null);
		model.addAttribute("id",idMax);
		model.addAttribute("boton","Inserta empleat");
		model.addAttribute("action","/insertar");
		model.addAttribute("buscar",buscar);
		return "listar_empleados";//listar_empleados.html
	}
	

	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {		
		Empleat empleat = bd.getEmpleat(id);		
		ArrayList<Empleat> empleats = bd.getEmpleats();		
		model.addAttribute("empleats", empleats);
		model.addAttribute("empleat", empleat);
		model.addAttribute("boton", "Actualitzar Empleat");		
		model.addAttribute("action","/modificar");//metodos controlador
//		model.addAttribute("buscar",buscar);
		return "listar_empleados";
	}
	
	@PostMapping("/modificar")
	public String modificar2(Empleat empleat, Model model) {
		ArrayList<Empleat> empleats = bd.getEmpleats();
		int idMax=0;
		bd.modificar(empleat);
		idMax= bd.getIdMax() + 1; // agregamos +1 al valor maximo del índice
		
		model.addAttribute("empleats", empleats);
		model.addAttribute("empleat", null);
		model.addAttribute("id", idMax);
		model.addAttribute("boton", "Inserta empleat");
		model.addAttribute("action", "/insertar");
		return "listar_empleados";
	}
	
	@PostMapping("/insertar")
	public String insertar(Empleat empleat, Model model) {
		int idMax=0;
		if(empleat != null) {
			bd.insertar(empleat);			
		}else {
			idMax= bd.getIdMax() + 1; // agregamos +1 al valor maximo del índice			
		}				
		ArrayList<Empleat> empleats = bd.getEmpleats();		
		model.addAttribute("empleats", empleats);
		model.addAttribute("empleat", null);
		model.addAttribute("id", idMax);		
		model.addAttribute("boton", "Inserta empleat");
		model.addAttribute("action", "/insertar");
		return "listar_empleados";
	}
	
	@GetMapping("/insertar")
	public String insertar2(Empleat empleat, Model model) {
		int idMax=0;
		if(empleat.getNom() != null) {
			bd.insertar(empleat);			
		}else {
			idMax= bd.getIdMax() + 1; // agregamos +1 al valor maximo del índice			
		}	
		
		ArrayList<Empleat> empleats = bd.getEmpleats();		
		model.addAttribute("empleats", empleats);
		//model.addAttribute("empleat", null);
		model.addAttribute("id", idMax);
		model.addAttribute("boton", "Inserta empleat");
		model.addAttribute("action", "/insertar");
		return "listar_empleados";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable int id, Model model) {
		//bd.borra(id);
		Empleat empleat = bd.getEmpleat(id);
		ArrayList<Empleat> empleats = bd.getEmpleats();
		model.addAttribute("empleats", empleats);
		model.addAttribute("empleat", empleat); 
		model.addAttribute("boton", "Borrar");
		model.addAttribute("action", "/borrar");
		return "listar_empleados";
	}
	
	@PostMapping("/borrar")
	public String borrar2(Empleat empleat, Model model) {
		int idMax=0;
		bd.borrar(empleat.getId());
		idMax= bd.getIdMax() + 1; // agregamos +1 al valor maximo del índice
		ArrayList<Empleat> empleats = bd.getEmpleats();
		model.addAttribute("empleats", empleats);
		model.addAttribute("empleat", null); // paso null para controlar formulario
		model.addAttribute("id", idMax);
		model.addAttribute("boton", "Inserta Empleat");
		model.addAttribute("action", "/insertar");
		return "listar_empleados";
		
	}

}
