package org.example.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o){
        if (this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return Objects.equals(name,that.name) && Objects.equals(age, that.age);
    }
    @Override
    public int hashCode(){
        return Objects.hash(name,age);
    }
}




