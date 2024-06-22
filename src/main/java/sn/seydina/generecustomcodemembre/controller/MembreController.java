package sn.seydina.generecustomcodemembre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.seydina.generecustomcodemembre.Services.MembreService;
import sn.seydina.generecustomcodemembre.controller.api.MembreApi;
import sn.seydina.generecustomcodemembre.model.Membre;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MembreController implements MembreApi {

    private final MembreService membreService;

    @Override
     public Membre saveMembre(@RequestBody Membre membre) {
        String code = this.membreService.genererCode(membre);
        membre.setCode(code);
        this.membreService.save(membre);
        return membre;
    }

    @Override
    public List<Membre> listeMembre() {
        return this.membreService.findAll();
    }

    @Override
    public Membre findById(Long id) {
        return this.membreService.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.membreService.deleteById(id);
    }

    @Override
    public Membre update(Long id, Membre membre) {
        return this.membreService.save(membre);
    }

    @Override
    public Membre findByCode(String code) {
        return this.membreService.findByCode(code);
    }
}
