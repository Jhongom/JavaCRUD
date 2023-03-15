
package com.gestion.demo.servicio;

import com.gestion.demo.repositorio.ProductoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion.demo.entidades.Producto;

//Define que es un servicio
@Service
public class Servicio {
    //Para inyectar el repositorio
    @Autowired
    private ProductoRepositorio productoRepositorio;
    
    public List<Producto> listAll(){
       
        return productoRepositorio.findAll();
    }
    
    public void save (Producto producto){
        productoRepositorio.save(producto);
    }
    public Producto get(long id){
        return productoRepositorio.findById(id).get();
    }
    public void delete(long id){
        productoRepositorio.deleteById(id);
    }
    
    
}
