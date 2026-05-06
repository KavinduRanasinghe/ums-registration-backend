package lk.ac.wusl.fas.ums_registration_backend.domain.util;

import java.util.List;
import java.util.Map;

import lk.ac.wusl.fas.ums_registration_backend.domain.enums.*;

public class CombinationMapping {
	
	public static final Map<Combination, List<Department>> MAP = Map.of(
			Combination.COMB1, List.of(Department.MATH_STAT, Department.CMIS, Department.ELTN),
			Combination.COMB2, List.of(Department.MATH_STAT, Department.ELTN, Department.IMGT),
			Combination.COMB3, List.of(Department.MATH_STAT, Department.IMGT, Department.CMIS)
	);
}
