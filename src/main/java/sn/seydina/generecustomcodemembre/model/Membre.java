package sn.seydina.generecustomcodemembre.model;

import jakarta.persistence.*;
import lombok.*;
import sn.seydina.generecustomcodemembre.enums.EnumSexe;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "membre")
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumSexe sexe;

    private LocalDateTime anneeAdhesion;
    private String code;
}
