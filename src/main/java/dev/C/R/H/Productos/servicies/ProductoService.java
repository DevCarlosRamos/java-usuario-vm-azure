package dev.C.R.H.Productos.servicies;

import dev.C.R.H.Productos.models.ProductoModel;
import dev.C.R.H.Productos.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public Flux<ProductoModel> listarProductos(){
        return productoRepository.findAll();
    }

    public Mono<ProductoModel> listarProducto(String idProducto){
        return productoRepository.findById(idProducto);
    }

    public Mono<ProductoModel> guardarProducto(ProductoModel productoModel){
        return productoRepository.save(productoModel);
    }

    public Mono<String> eliminarProducto(String idProducto) {
        return productoRepository.deleteById(idProducto)
                .then(productoRepository.existsById(idProducto))
                .flatMap(existe -> existe ? Mono.just("Producto No Encontrado") : Mono.just("Producto Eliminado"));
    }

}
