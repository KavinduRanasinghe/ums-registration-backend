package lk.ac.wusl.fas.ums_registration_backend.application.service.hall;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.Hall;

import lk.ac.wusl.fas.ums_registration_backend.domain.repository.HallRepository;

@Service
@RequiredArgsConstructor
public class HallService {
	
	private final HallRepository repository;
	
	// GET ALL
	
	public List<Hall> getAll() {
		
		return repository.findAll();
	}
	
	// SAVE
	
	public Hall save(
			Hall hall
	) {
		
		return repository.save(hall);
	}
	
	// DELETE
	
	public void delete(
			String id
	) {
		
		repository.deleteById(
				UUID.fromString(id)
		);
	}
	
	// UPDATE CAPACITY
	
	public Hall updateCapacity(
			
			String id,
			
			Integer capacity
	) {
		
		Hall hall =
				repository.findById(
						UUID.fromString(id)
				).orElseThrow();
		
		hall.setCapacity(capacity);
		
		return repository.save(hall);
	}
}
