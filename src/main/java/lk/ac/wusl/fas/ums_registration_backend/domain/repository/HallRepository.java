package lk.ac.wusl.fas.ums_registration_backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.Hall;

public interface HallRepository
		extends JpaRepository<Hall, UUID> {
	
	List<Hall> findByActiveTrue();
}
