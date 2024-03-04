package com.example.examenspringboot.controller;

import com.example.examenspringboot.model.Cliente;
import com.example.examenspringboot.respo.ClienteRepository;
import com.example.examenspringboot.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 Nombre: Fernando Pérez de Ayala Blázquez
 Ciclo: 2ºDAM
 */

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repositoryCliente;
    @Autowired
    private SecurityService securityService;


    @PostMapping("/nuevo")
    public ResponseEntity<Cliente> nuevo(@RequestBody Cliente cliente, @RequestParam String token) {
        if (SecurityService.validateToken(token)) {
            return new ResponseEntity<>(repositoryCliente.save(cliente), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getClienteStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("sumaTotales:", repositoryCliente.getSumaTotales());
        stats.put("mediaTotalClientesActivos", repositoryCliente.getMediaTotalClientesActivos());
        stats.put("numeroClientesInactivosTotalMayoCero", repositoryCliente.getNumeroClientesInactivosTotalMayoCero());

        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public Cliente getClientePorId(@PathVariable Long id){
        return repositoryCliente.getClienteById(id);
    }

    @GetMapping("/activosVentaMayor/{total}")
    public List<Cliente> getClientesActivosConVentasMayor(@PathVariable Double total){
        return repositoryCliente.getActivosPorVentaMayor(total);
    }

}
