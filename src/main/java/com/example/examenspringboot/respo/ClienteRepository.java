package com.example.examenspringboot.respo;

import com.example.examenspringboot.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
 Nombre: Fernando Pérez de Ayala Blázquez
 Ciclo: 2ºDAM
 */

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente getClienteById(Long id);

    @Query("SELECT c FROM Cliente c WHERE c.estado = 'Activo' AND c.total > :total")
    List<Cliente> getActivosPorVentaMayor(Double total);

    @Query(value = "SELECT SUM(c.total) FROM Cliente c")
    Double getSumaTotales();

    @Query("SELECT AVG(c.total) FROM Cliente c WHERE c.estado = 'Activo'")
    Double getMediaTotalClientesActivos();

    @Query("SELECT COUNT(c) FROM Cliente c WHERE c.estado = 'Inactivo' AND c.total > 0")
    Integer getNumeroClientesInactivosTotalMayoCero();
}
