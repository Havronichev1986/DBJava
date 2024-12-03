package org.example.mappers;

import org.example.dtos.TemplateDto;
import org.example.dtos.TimeDto;
import org.example.entities.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PersonMapper {

    @Mapping(target = "age", source = "personEntity.age")
    @Mapping(target = "name", source = "personEntity.name")
    @Mapping(target = "profession", constant = "Программист")
    @Mapping(target = "registration", source = "localDateTime.registration")
    public abstract TemplateDto map(PersonEntity personEntity, TimeDto localDateTime);

    @Named("validateName")
    public String validateName(String name){
        return name.toUpperCase();
    }
    @Mapping(target = "id", ignore = true)
    public abstract PersonEntity map(TemplateDto templateDto);
    public abstract List<TemplateDto> map(List<PersonEntity> personEntityList);
    public abstract List<PersonEntity> mapList(List<TemplateDto> templateDtoList);
}
