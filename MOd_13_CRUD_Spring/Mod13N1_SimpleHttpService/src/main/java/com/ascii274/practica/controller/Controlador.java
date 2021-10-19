package com.ascii274.practica.controller;

import java.util.ArrayList;
import java.util.Collections;

import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ascii274.practica.bean.Empleat;
import com.ascii274.practica.repository.BaseDatosArray;

import net.bytebuddy.asm.Advice.Exit;

@Controller // lo convertimos en un servlet atiende a peticiones http
@RequestMapping("")

public class Controlador {
	Empleat empleat;
	BaseDatosArray bd = new BaseDatosArray();
	
	/**
	 * - Get: requesta data
	 * - Inicio del web le pasamos por parametro Model
	 * @param model
	 * @return
	 */
	@GetMapping ("/")
	public String inicioBusqueda(Model model) {
		model.addAttribute("titol", "Formulari de recerca");
		model.addAttribute("titolTextRecerca","Introdueix un text de recerca:");			
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
		//pasamos por parametor 'buscar'=valor(buscar)
		ArrayList<Empleat> empleats = new ArrayList<Empleat>();
		if(buscar!="") {
			empleats = bd.returnJobsSearch(buscar); 
		}else {
			empleats = bd.getEmpleats();			
		}
		model.addAttribute("empleats",empleats);		
		model.addAttribute("buscar",buscar);
		model.addAttribute("boton", "Inserta Empleat");	
		model.addAttribute("action", "/insertar");			
		return "listar_empleados" ;//listar_empleados.html
	}
	
	/**
	 * - Mostra la recerca si hi hi dades, si no totes les dades.
	 * @param model
	 * @param buscar
	 * @return
	 */
	@GetMapping("/buscar/{buscar}")
	public String buscar2(Model model, @RequestParam String buscar) {
		//pasamos por parametor 'buscar'=valor(buscar)
		ArrayList<Empleat> empleats = new ArrayList<Empleat>();
		if(buscar!="") {
			empleats = bd.returnJobsSearch(buscar); 
		}else {
			empleats = bd.getEmpleats();			
		}
		model.addAttribute("empleats",empleats);
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
		return "listar_empleados";
	}
	
	@PostMapping("/modificar")
	public String modificar2(Empleat empleat, Model model) {
		bd.modifica(empleat);
		ArrayList<Empleat> empleats = bd.getEmpleats();
		model.addAttribute("empleats", empleats);
		model.addAttribute("empleat", null);
		model.addAttribute("boton", "Inserta empleat");
		model.addAttribute("action", "/insertar");
		return "listar_empleados";
	}
	
	@PostMapping("/insertar")
	public String insertar(Empleat empleat, Model model) {
		bd.inserta(empleat);
		ArrayList<Empleat> empleats = bd.getEmpleats();		
		model.addAttribute("empleats", empleats);
		model.addAttribute("empleat", null);
		model.addAttribute("boton", "Inserta empleat");
		model.addAttribute("action", "/insertar");
		return "listar_empleados";
	}
	
	@GetMapping("/insertar")
	public String insertar2(Empleat empleat, Model model) {
		//bd.inserta(empleat);
		ArrayList<Empleat> empleats = bd.getEmpleats();		
		model.addAttribute("empleats", empleats);
		model.addAttribute("empleat", empleat);
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
		model.addAttribute("empleat", empleat); // paso null para controlar formulario
		model.addAttribute("boton", "Borrar");
		model.addAttribute("action", "/borrar");
		return "listar_empleados";
	}
	
	@PostMapping("/borrar")
	public String borrar2(Empleat empleat, Model model) {		
		bd.borra(empleat.getId());
		ArrayList<Empleat> empleats = bd.getEmpleats();
		model.addAttribute("empleats", empleats);
		model.addAttribute("empleat", null); // paso null para controlar formulario
		model.addAttribute("boton", "Borrar");
		model.addAttribute("action", "/borrar");
		return "listar_empleados";
	}

}
