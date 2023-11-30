
package com.utn.repositories;

import com.utn.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Long> {
    
    Cliente findByDni(int dni);
}
