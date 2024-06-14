package com.javaded.web.mapper;

import com.javaded.domain.model.Client;
import com.javaded.web.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
}
