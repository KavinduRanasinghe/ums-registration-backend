package lk.ac.wusl.fas.ums_registration_backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.CombinationCapacity;
import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Combination;

public interface CombinationCapacityRepository
		extends JpaRepository<CombinationCapacity, UUID> {
	
	Optional<CombinationCapacity> findByCombination(
			Combination combination
	);
}
