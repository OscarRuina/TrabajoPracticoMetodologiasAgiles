package com.unla.pedidosya;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.repository.INegocioRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class NegocioRepositoryTest {

    @Autowired
    private INegocioRepository repo;

    @Test
    public void testInsertNegocio(){

        Negocio save = repo.save(new Negocio("la nueva","av alsina 500",
        "lomas de zamora"));

        assertTrue(save.getIdNegocio() > 0 );

    }
    
}
