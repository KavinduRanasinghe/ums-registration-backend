package lk.ac.wusl.fas.ums_registration_backend.application.service.timetable;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.TimetableRule;

import lk.ac.wusl.fas.ums_registration_backend.domain.repository.TimetableRuleRepository;

@Service
@RequiredArgsConstructor
public class TimetableRuleService {
	
	private final TimetableRuleRepository repository;
	
	// GET ALL RULES
	
	public List<TimetableRule> getAll() {
		
		return repository.findAll();
	}
	
	// SAVE RULE
	
	public TimetableRule save(
			TimetableRule rule
	) {
		
		return repository.save(rule);
	}
	
	// DELETE RULE
	
	public void delete(
			String id
	) {
		
		repository.deleteById(
				java.util.UUID.fromString(id)
		);
	}
}
