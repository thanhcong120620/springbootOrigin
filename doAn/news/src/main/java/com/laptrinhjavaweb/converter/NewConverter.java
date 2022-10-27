package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

@Component
public class NewConverter {

	public NewEntity toEntity(NewDTO dto) {
		NewEntity entity = new NewEntity();//because to add new News, we create new Object
		
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());
		
		return entity;
	}
	
	
	
	public NewDTO toDTO(NewEntity entity) {
		NewDTO dto = new NewDTO();
		
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		
		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		dto.setShortDescription(entity.getShortDescription());
		dto.setThumbnail(entity.getThumbnail());
		
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	
	
	public NewEntity toEntity(NewDTO dto, NewEntity entity) {
		//because to update a old News with new data from DTO, we use old Object to change data
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());
		
		return entity;
	}
	
}
