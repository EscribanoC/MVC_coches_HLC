package com.hlc.mvc_coche.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hlc.mvc_coche.entidades.Coche;
import com.hlc.mvc_coche.servicio.CocheServicio;


@Controller
public class CocheControlador {
        @Autowired
        CocheServicio cocheServicio;

         @GetMapping("/")
        public String listarCoche(Model model) {
            model.addAttribute("coches", cocheServicio.listarCoches());
            return "index";
        }

        @GetMapping("/coche/nuevo")
        public String mostrarFormularioDeNuevoCoche(Model model) {
            Coche coche = new Coche();
            model.addAttribute("coche", coche);
            return "coche-form";
        }

        @GetMapping("/coche/editar/{id}")
        public String mostrarFormularioDeEditarCoche(@PathVariable Long id, Model model) {
            Coche coche = cocheServicio.obtenerPorId(id);
            model.addAttribute("coche", coche);
            return "coche-form"; 
        }

        @PostMapping("/coche")
        public String guardarCoche(@ModelAttribute Coche coche) {
            cocheServicio.guardarCoche(coche);
            return "redirect:/";
        }

        @GetMapping("/coche/eliminar/{id}")
        public String eliminarCoche(@PathVariable Long id) {
            cocheServicio.eliminarCoche(id);
            return "redirect:/";
        }
    }