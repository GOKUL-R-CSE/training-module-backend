package com.trainng.main.service;

import java.util.List;

import com.trainng.main.entity.TrainingModule;


public interface TrainingModuleService {

	TrainingModule addModule(TrainingModule module);

	List<TrainingModule> getModule();

	TrainingModule getModuleById(long id);

	void deleteModule(long id);

	TrainingModule updateModule(long id, TrainingModule module);

}
