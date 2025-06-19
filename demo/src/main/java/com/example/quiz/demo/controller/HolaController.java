package com.example.quiz.demo.controller;

import com.example.quiz.demo.model.Saludo;
import com.example.quiz.demo.model.SaludoRequest;
import com.example.quiz.demo.repository.SaludoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class HolaController {

    @Autowired
    private SaludoRepository saludoRepository;

    @GetMapping("/hola")
    public String saludar(@RequestParam(defaultValue = "amigo") String nombre) {
        return "Hola desde Spring boot "+nombre+" !!!";
    }

    @PostMapping("/saludo")
    public String saludarConJson(@RequestBody SaludoRequest request) {
        Saludo saludo = new Saludo(request.getNombre(), request.getApellido());
        saludoRepository.save(saludo);
        return "¡Hola " + request.getNombre() + " " + request.getApellido() +" eres un maquina!";
    }

    @GetMapping("/saludos")
    public List<Saludo> getSaludos() {
        return saludoRepository.findAll();
    }
    @PutMapping("/saludo/{id}")
    public String actualizarSaludo(@PathVariable Long id, @RequestBody SaludoRequest request) {
        return saludoRepository.findById(id)
                .map(saludo -> {
                    saludo.setNombre(request.getNombre());
                    saludo.setApellido(request.getApellido());
                    saludoRepository.save(saludo);
                    return "Saludo actualizado correctamente";
                })
                .orElse("No se encontró un saludo con ese ID");
    }
    @DeleteMapping("/saludo/{id}")
    public String eliminarSaludo(@PathVariable Long id) {
        if (saludoRepository.existsById(id)) {
            saludoRepository.deleteById(id);
            return "Saludo eliminado correctamente";
        } else {
            return "No se encontró un saludo con ese ID";
        }
    }
    @PostMapping("/saludos")
    public String guardarVariosSaludos(@RequestBody List<SaludoRequest> lista) {
        List<Saludo> saludos = lista.stream()
                .map(item -> new Saludo(item.getNombre(), item.getApellido()))
                .toList();

        saludoRepository.saveAll(saludos);
        return "Saludo múltiple guardado correctamente (" + saludos.size() + ")";
    }
}


