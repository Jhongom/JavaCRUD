package com.gestion.demo.controlador;

import com.gestion.demo.entidades.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gestion.demo.servicio.Servicio;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductoControlador {

    @Autowired
    private Servicio servicio;

    @RequestMapping("/")
    public String verPaginaDeInicio(Model model) {
        //Obtiene los datos de la lista del mySQL

        List<Producto> listaProductos = servicio.listAll();

        model.addAttribute("listaProductos", listaProductos);

        return "index";
    }

    @RequestMapping("/nuevo")
    public String mostrarFormularioDeRegistrarProducto(Model modelo) {
        Producto producto = new Producto();
        modelo.addAttribute("producto", producto);
        return "nuevo_producto";

    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardarProdcuto(@ModelAttribute("producto") Producto producto) {
        servicio.save(producto);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView mostrarFormularioDeRegistrarProducto(@PathVariable(name = "id") long id) {
        ModelAndView modelo = new ModelAndView("editar_producto");

        Producto producto = servicio.get(id);
        modelo.addObject("producto", producto);

        return modelo;

    }

    @RequestMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable(name = "id") Long id) {
        servicio.delete(id);
        return "redirect:/";

    }

}
