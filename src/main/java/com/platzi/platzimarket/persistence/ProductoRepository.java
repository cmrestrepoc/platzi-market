package com.platzi.platzimarket.persistence;

import com.platzi.platzimarket.persistence.crud.ProductoCrudRepository;
import com.platzi.platzimarket.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll(); // CrudRepository method
    }

    public List<Producto> getByCategoriaOrdered(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria); // using query method
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoria(idCategoria); // using query method
    }

    public Optional<List<Producto>> getEscasos(int cantidad, boolean estado) {
        return productoCrudRepository.findByCandidadStockLessThanAndEstado(cantidad, estado);
    }
}
