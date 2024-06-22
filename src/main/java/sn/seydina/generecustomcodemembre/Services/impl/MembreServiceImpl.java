package sn.seydina.generecustomcodemembre.Services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.seydina.generecustomcodemembre.Services.MembreService;
import sn.seydina.generecustomcodemembre.enums.EnumSexe;
import sn.seydina.generecustomcodemembre.model.CompteurMembre;
import sn.seydina.generecustomcodemembre.model.Membre;
import sn.seydina.generecustomcodemembre.repository.CompteurMembreRepository;
import sn.seydina.generecustomcodemembre.repository.MembreRepository;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MembreServiceImpl implements MembreService {

    private final CompteurMembreRepository compteurMembreRepository;
    private final MembreRepository membreRepository;

    @Override
    public Membre save(Membre membre) {
        return this.membreRepository.save(membre);
    }

    @Override
    public Membre findById(Long id) {
        return this.membreRepository.findById(id).orElse(null);
    }

    @Override
    public Membre findByCode(String code) {
        return this.membreRepository.findByCode(code);
    }

    @Override
    public Membre findByAnneeAdhesion(LocalDateTime anneeAdhesion) {
        return this.membreRepository.findByAnneeAdhesion(anneeAdhesion);
    }

    @Override
    public List<Membre> findAll() {
        return this.membreRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.membreRepository.deleteById(id);
    }

    @Override
    @Transactional
     public String genererCode(Membre membre) {
        String prefixe = "DFF";
        String sexeCode = (membre.getSexe() == EnumSexe.MASCULIN) ? "1" : "2";
        String annee = String.valueOf(membre.getAnneeAdhesion().getYear());
        int compteur = incrementerCompteur(membre.getSexe(), membre.getAnneeAdhesion());

        return prefixe + sexeCode + annee + String.format("%04d", compteur);
    }

    @Override
    public int incrementerCompteur(EnumSexe sexe, LocalDateTime annee) {

        CompteurMembre compteurMembre = this.compteurMembreRepository.findBySexeAndAnnee(sexe, annee);

        if (compteurMembre == null) {
            compteurMembre = CompteurMembre.builder()
                    .sexe(sexe)
                    .annee(annee)
                    .compteur(0)
                    .build();
        }

        compteurMembre.setCompteur(compteurMembre.getCompteur() + 1);
        compteurMembreRepository.save(compteurMembre);

        return compteurMembre.getCompteur();
    }
}
