package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;

@Service
public class NewService implements INewService {
	
	@Autowired
	NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryReposity;
	
	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if(newDTO.getId() != null) {
			NewEntity oldEntity = newRepository.findById(newDTO.getId()).get();
			newEntity = newConverter.toEntity(newDTO, oldEntity);
		} else {
			newEntity = newConverter.toEntity(newDTO);
		}
		CategoryEntity categoryEntity = categoryReposity.findOneByCode(newDTO.getCategoryCode());
//		NewEntity newEntity = newConverter.toEntity(newDTO);
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		
		return newConverter.toDTO(newEntity);
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for(long item : ids) {
			newRepository.deleteById(item);
		}
		
	}

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		for (NewEntity item: entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}

	@Override
	public List<NewDTO> findAll() {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll();
		for (NewEntity item: entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		return (int) newRepository.count();
	}

	/*
	@Override
	public NewDTO update(NewDTO newDTO) {
//		Optional<NewEntity> oldEntity = newRepository.findById(newDTO.getId());
		NewEntity oldEntity = newRepository.findById(newDTO.getId()).get();
		NewEntity newEntity = newConverter.toEntity(newDTO, oldEntity);
		
		CategoryEntity categoryEntity = categoryReposity.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		
//		 * In data JPA method set has 2 role:
//		 * If id is null, method save is adding, 
//		 * If id is not null, method save is updating,
		newEntity = newRepository.save(newEntity);
		
		return newConverter.toDTO(newEntity);
	}
	*/
}
