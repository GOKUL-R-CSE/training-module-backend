package com.trainng.main.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainng.main.entity.TrainingModule;
import com.trainng.main.exception.ResourceAlreadyExistsException;
import com.trainng.main.exception.ResourceNotFoundException;
import com.trainng.main.repository.TrainingModuleRepository;
import com.trainng.main.service.TrainingModuleService;

@Service

public class TrainingModuleServiceImpl implements TrainingModuleService{
	
	@Autowired
	private TrainingModuleRepository moduleRepository;

	@Override
	public TrainingModule addModule(TrainingModule module) {
		Optional<TrainingModule> mod = Optional.ofNullable(moduleRepository.findByName(module.getName()));
		if(mod.isPresent()) {
			throw new ResourceAlreadyExistsException("Module", "specified name");
		}
		else {
		moduleRepository.save(module);
		}
		return module;
	}

	@Override
	public List<TrainingModule> getModule() {
		List<TrainingModule> modules = moduleRepository.findAll();
		return modules;
	}

	@Override
	public TrainingModule getModuleById(long id) {
		Optional<TrainingModule> module = moduleRepository.findById(id);
		if(module.isPresent()) {
			return module.get();
		}
		else {
			throw new ResourceNotFoundException("Module", "specified id");
		}
	}

	@Override
	public void deleteModule(long id) {
		moduleRepository.deleteById(id);
	}

	@Override
	public TrainingModule updateModule(long id, TrainingModule module) {
		TrainingModule mod = moduleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Module", "specified id"));
			if(Objects.nonNull(module.getName()) && !"".equals(module.getName())){
			mod.setName(module.getName());
			}
			if(Objects.nonNull(module.getDescription()) && !"".equals(module.getDescription())) {
			}
			if(Objects.nonNull(module.getImage()) && !"".equals(module.getImage())) {
			mod.setImage(module.getImage());
			}
			if(Objects.nonNull(module.getImageLink()) && !(module.getImageLink().isEmpty())) {
			mod.setImageLink(module.getImageLink());
			}
			if(Objects.nonNull(module.getTopics()) && !(module.getTopics().isEmpty())) {
			mod.setTopics(module.getTopics());
			}
			if(Objects.nonNull(module.getTopicDes()) && !(module.getTopicDes().isEmpty())) {
			mod.setTopicDes(module.getTopicDes());
			}
			moduleRepository.save(mod);
			return mod;
	}
	


}
