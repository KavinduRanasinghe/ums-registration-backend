package lk.ac.wusl.fas.ums_registration_backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.TimetableRule;

public interface TimetableRuleRepository
		extends JpaRepository<TimetableRule, UUID> {
}
