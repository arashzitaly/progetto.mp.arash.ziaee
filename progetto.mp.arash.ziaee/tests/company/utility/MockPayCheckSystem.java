package company.utility;

import java.util.HashMap;
import java.util.Map;

import company.Staff;
import company.payment.PayingSystem;

public class MockPayCheckSystem implements PayingSystem{
	
	private Map<String, Double> salaryMapping = new HashMap<>();

	@Override
	public void renderPayCheck(Staff staff, double salary) {
		salaryMapping.put(staff.getName(), salary);
	}
	
	public double getSalary(Staff staff) {
		return salaryMapping.get(staff.getName());
	}
	
	public int getSize() {
		return salaryMapping.size();
	}

	
}
