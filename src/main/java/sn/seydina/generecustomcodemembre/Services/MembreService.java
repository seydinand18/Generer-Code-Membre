package sn.seydina.generecustomcodemembre.Services;


import jakarta.transaction.Transactional;
import sn.seydina.generecustomcodemembre.enums.EnumSexe;
import sn.seydina.generecustomcodemembre.model.Membre;
import java.time.LocalDateTime;
import java.util.List;

public interface MembreService {

    Membre save(Membre membre);

    Membre findById(Long id);

    Membre findByCode(String code);

    Membre findByAnneeAdhesion(LocalDateTime anneeAdhesion);

    List<Membre> findAll();

    void deleteById(Long id);

    @Transactional
    String genererCode(Membre membre);

    int incrementerCompteur(EnumSexe sexe, LocalDateTime annee);
}
