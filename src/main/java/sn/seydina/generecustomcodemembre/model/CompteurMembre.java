package sn.seydina.generecustomcodemembre.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.seydina.generecustomcodemembre.enums.EnumSexe;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "compteur_membre")
public class CompteurMembre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private EnumSexe sexe;
    private LocalDateTime annee;
    private int compteur;
}
