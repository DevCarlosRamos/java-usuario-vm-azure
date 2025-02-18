package dev.C.R.H.Productos.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class ProductoModel {

    @Id
    private String idProducto;
    private String nombre;
    private Double precio;
    private int cantidad;
}
