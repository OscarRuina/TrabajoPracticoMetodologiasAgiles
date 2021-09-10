package com.unla.pedidosya;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.entity.Producto;
import com.unla.pedidosya.repository.INegocioRepository;
import com.unla.pedidosya.repository.IProductoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductoRepositoryTest {

    @Autowired
    private IProductoRepository productoRepo;

    @Autowired
    private INegocioRepository negocioRepo;

    @Test
    public void insertProduct(){

        Negocio n = negocioRepo.findById((long)1).orElseThrow(null);

        Producto save = productoRepo.save(new Producto("hamburguesa","hamburguesa simple","hamburguesa",100.0f,n));

        assertTrue(save.getIdProducto() > 0);

    }
    
}
