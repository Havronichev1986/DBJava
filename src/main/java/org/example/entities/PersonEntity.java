package org.example.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonEntity {
    @Id
    @SequenceGenerator(name = "generator_pers", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_pers")
    private Long id;

    @Column(name = "name")
    @Schema(example = "Алексей")
    private String name;

    @Schema(example = "37")
    @Column(name = "age")
    private Short age;
}
