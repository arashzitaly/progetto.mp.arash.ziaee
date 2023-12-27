package companyStructure;

import java.util.Objects;

import company.utils.print.StaffPrinter;

public abstract class Staff {

	
	private String name;

	protected Staff(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "name=" + name + "\n";
	}
	
	public abstract double calculateSalary();
	
	public abstract void printMember(StaffPrinter printer);
	
	
}
