package com.example.productmanager.controller;

import com.example.productmanager.model1.Produs;
import com.example.productmanager.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produse")
public class ProdusController {

    @Autowired
    private ProdusService produsService;

    // Metoda GET pentru a obține toate produsele
    @GetMapping
    public List<Produs> getAllProduse() {
        System.out.println("Endpoint-ul /api/produse a fost accesat.");
        return produsService.getAllProduse();
    }

    // Metoda GET pentru a obține un produs după ID
    @GetMapping("/{id}")
    public ResponseEntity<Produs> getProdusById(@PathVariable Long id) {
        return produsService.getProdusById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Metoda POST pentru a crea un nou produs
    @PostMapping
    public Produs createProdus(@RequestBody Produs produs) {
        return produsService.saveProdus(produs);
    }

    // Metoda PUT pentru a actualiza un produs după ID
    @PutMapping("/{id}")
    public ResponseEntity<Produs> updateProdus(@PathVariable Long id, @RequestBody Produs produsDetails) {
        return produsService.updateProdus(id, produsDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Metoda DELETE pentru a șterge un produs după ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdus(@PathVariable Long id) {
        if (produsService.deleteProdus(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
