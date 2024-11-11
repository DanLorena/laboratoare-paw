package com.example.productmanager.service;

import com.example.productmanager.model1.Produs;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProdusService {

    private final Map<Long, Produs> produse = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    // Constructor pentru a adăuga produse de test
    public ProdusService() {
        // Adăugăm câteva produse de test la început
        produse.put(counter.getAndIncrement(), new Produs(1L, "Produs1", 100.0, 10));
        produse.put(counter.getAndIncrement(), new Produs(2L, "Produs2", 150.0, 20));
        produse.put(counter.getAndIncrement(), new Produs(3L, "Produs3", 200.0, 30));
    }

    // Metoda pentru a obține toate produsele
    public List<Produs> getAllProduse() {
        return new ArrayList<>(produse.values());
    }

    // Metoda pentru a obține un produs după ID
    public Optional<Produs> getProdusById(Long id) {
        return Optional.ofNullable(produse.get(id));
    }

    // Metoda pentru a salva un produs
    public Produs saveProdus(Produs produs) {
        if (produs.getId() == null) {
            produs.setId(counter.getAndIncrement());
        }
        produse.put(produs.getId(), produs);
        return produs;
    }

    // Metoda pentru a actualiza un produs
    public Optional<Produs> updateProdus(Long id, Produs produsDetails) {
        Produs produs = produse.get(id);
        if (produs != null) {
            produs.setNume(produsDetails.getNume());
            produs.setPret(produsDetails.getPret());
            produs.setStoc(produsDetails.getStoc());
            return Optional.of(produs);
        }
        return Optional.empty();
    }

    // Metoda pentru a șterge un produs
    public boolean deleteProdus(Long id) {
        return produse.remove(id) != null;
    }
}
