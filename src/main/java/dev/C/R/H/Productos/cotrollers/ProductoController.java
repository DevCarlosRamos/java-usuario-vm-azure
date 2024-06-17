package dev.C.R.H.Productos.cotrollers;

import dev.C.R.H.Productos.models.ProductoModel;
import dev.C.R.H.Productos.servicies.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/productos")
    public Flux<ProductoModel> listarProductos(){
        return  productoService.listarProductos();
    }

    @GetMapping("/producto/{idProducto}")
    public Mono<ProductoModel> listarProducto(@PathVariable String idProducto){
        return productoService.listarProducto(idProducto);
    }

    @PostMapping("/producto")
    public Mono<ProductoModel> guardarProducto(@RequestBody ProductoModel productoModel){
        return productoService.guardarProducto(productoModel);
    }

    @DeleteMapping("/producto/{idProducto}")
    public Mono<String> eliminarProducto(@PathVariable String idProducto){
        return productoService.eliminarProducto(idProducto);
    }
}
