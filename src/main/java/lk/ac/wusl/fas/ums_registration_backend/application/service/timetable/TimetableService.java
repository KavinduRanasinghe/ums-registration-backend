package lk.ac.wusl.fas.ums_registration_backend.application.service.timetable;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.*;

import lk.ac.wusl.fas.ums_registration_backend.domain.repository.*;

@Service
@RequiredArgsConstructor
public class TimetableService {
	
	private final TimetableRepository timetableRepository;
	
	private final LecturerModuleRepository lecturerModuleRepository;
	
	// =====================================
	// GENERATE TIMETABLE
	// =====================================
	
	public List<Timetable> generate() {
		
		// CLEAR OLD TIMETABLE
		
		timetableRepository.deleteAll();
		
		List<LecturerModule> modules =
				lecturerModuleRepository.findAll();
		
		List<Timetable> generated =
				new ArrayList<>();
		
		// DAYS
		
		String[] days = {
				
				"MONDAY",
				"TUESDAY",
				"WEDNESDAY",
				"THURSDAY",
				"FRIDAY"
		};
		
		// TIME SLOTS
		
		LocalTime[] slots = {
				
				LocalTime.of(8, 0),
				LocalTime.of(10, 0),
				LocalTime.of(13, 0),
				LocalTime.of(15, 0)
		};
		
		int dayIndex = 0;
		
		int slotIndex = 0;
		
		for (LecturerModule module : modules) {
			
			String day =
					days[dayIndex];
			
			LocalTime start =
					slots[slotIndex];
			
			LocalTime end =
					start.plusHours(2);
			
			// =====================================
			// CHECK LECTURER CLASH
			// =====================================
			
			boolean lecturerBusy =
					
					timetableRepository
							
							.existsByLecturerIdAndDayAndStartTime(
									
									module.getLecturerId(),
									
									day,
									
									start
							);
			
			// IF BUSY → SKIP SLOT
			
			if (lecturerBusy) {
				
				slotIndex++;
				
				if (slotIndex >= slots.length) {
					
					slotIndex = 0;
					
					dayIndex++;
					
					if (dayIndex >= days.length) {
						
						dayIndex = 0;
					}
				}
				
				continue;
			}
			
			// =====================================
			// CREATE TIMETABLE ENTRY
			// =====================================
			
			Timetable timetable =
					
					Timetable.builder()
							
							.moduleCode(
									module.getModuleCode()
							)
							
							.moduleName(
									module.getModuleName()
							)
							
							.lecturerId(
									module.getLecturerId()
							)
							
							.lecturerName(
									module.getLecturerName()
							)
							
							.day(day)
							
							.startTime(start)
							
							.endTime(end)
							
							.venue("Hall A")
							
							.build();
			
			generated.add(
					
					timetableRepository.save(
							timetable
					)
			);
			
			// =====================================
			// NEXT SLOT
			// =====================================
			
			slotIndex++;
			
			if (slotIndex >= slots.length) {
				
				slotIndex = 0;
				
				dayIndex++;
				
				if (dayIndex >= days.length) {
					
					dayIndex = 0;
				}
			}
		}
		
		return generated;
	}
	
	// =====================================
	// GET ALL TIMETABLES
	// =====================================
	
	public List<Timetable> getAll() {
		
		return timetableRepository.findAll();
	}
}
