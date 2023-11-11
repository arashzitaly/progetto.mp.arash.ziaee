package companyStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import company.utils.print.StaffPrinter;

public abstract class Developers extends Staff {
	
	private Collection<Staff> programmer = new ArrayList<>();

	protected Developers(String name) {
		super(name);
	}
	
	// Builder ToDo
	
	// Methods to manage child component
	public void addProgrammer(Staff devs) {
		if(devs != null)
			programmer.add(devs);
	}
	
	public void removeProgrammer(Staff devs) {
		programmer.remove(devs);
	}

	@Override
    public abstract void join(Staff group);
    
    @Override
    public abstract void leave(Staff group);

    @Override
    public abstract double calculateSalary();

    @Override
    public abstract void printMember(StaffPrinter printer);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(programmer);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Developers other = (Developers) obj;
		return Objects.equals(programmer, other.programmer);
	}

}
