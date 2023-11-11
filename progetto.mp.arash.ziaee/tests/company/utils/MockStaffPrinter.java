package company.utils;

import company.utils.print.StaffPrinter;

public class MockStaffPrinter implements StaffPrinter{

	private StringBuilder builder = new StringBuilder();
	
	@Override
	public void print(String message) {
		builder.append(message + "\n");
	}

	@Override
	public String toString() {
		return builder.toString();
	}
	
	

	
}
