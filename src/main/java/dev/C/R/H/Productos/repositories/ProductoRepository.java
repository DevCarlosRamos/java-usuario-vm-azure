package dev.C.R.H.Productos.repositories;

import dev.C.R.H.Productos.models.ProductoModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductoRepository extends ReactiveMongoRepository<ProductoModel,String> {
}
