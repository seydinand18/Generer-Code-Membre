package sn.seydina.generecustomcodemembre.controller.api;

import org.springframework.web.bind.annotation.*;
import sn.seydina.generecustomcodemembre.model.Membre;
import java.util.List;

@RequestMapping("/api/v1/membre")
public interface MembreApi {

    @PostMapping
    Membre saveMembre(@RequestBody Membre membre);

    @GetMapping
    List<Membre> listeMembre();

    @GetMapping("/{id}")
    Membre findById(@PathVariable Long id);

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id);

    @PutMapping("/{id}")
    Membre update(@PathVariable Long id, @RequestBody Membre membre);

    @GetMapping("/code/{code}")
    Membre findByCode(@PathVariable String code);
}
