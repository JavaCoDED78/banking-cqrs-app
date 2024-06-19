package com.javaded.web.mapper;

import com.javaded.domain.model.Card;
import com.javaded.web.dto.CardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
}
