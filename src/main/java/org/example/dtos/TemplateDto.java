package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TemplateDto {
    @Schema(description = "Имя пользователя" , example = "Mike")
    private String name;

    @Schema(description = "Возраст пользователя" , example = "65")
    private String age;

    @Schema(description = "Профессия", example = "Повар")
    private String profession;

    @Schema(description = "Время регистрации", example = "2024.12.12 13:13:13")
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDateTime registration;
}
