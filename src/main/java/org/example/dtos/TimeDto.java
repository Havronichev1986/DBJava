package org.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeDto {
    private LocalDateTime registration = LocalDateTime.now();
    private LocalDateTime creation = LocalDateTime.of(2024,12,12,13,25);

}
