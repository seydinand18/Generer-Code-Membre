package sn.seydina.generecustomcodemembre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.seydina.generecustomcodemembre.model.Membre;
import java.time.LocalDateTime;

public interface MembreRepository extends JpaRepository<Membre, Long> {
    Membre findByCode(String code);

    Membre findByAnneeAdhesion(LocalDateTime anneeAdhesion);
}
