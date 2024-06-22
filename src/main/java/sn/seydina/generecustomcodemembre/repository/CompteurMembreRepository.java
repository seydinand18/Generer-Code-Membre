package sn.seydina.generecustomcodemembre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.seydina.generecustomcodemembre.enums.EnumSexe;
import sn.seydina.generecustomcodemembre.model.CompteurMembre;
import java.time.LocalDateTime;

public interface CompteurMembreRepository extends JpaRepository<CompteurMembre, Long>{
    CompteurMembre findBySexeAndAnnee(EnumSexe sexe, LocalDateTime annee);
}
