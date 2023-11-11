package companyStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import company.utils.print.StaffPrinter;

public final class DotNetGroup extends Developers {

	private int level;
	private String primaryLanguage;
	private int yearsOfExperience;
	private List<Staff> members;

	private DotNetGroup(String name, int level) {
		super(name);
		this.level = level;
		this.members = new ArrayList<>();
	}


	public static class DotNetBuilder {
		private String name;
		private int level;
		private String primaryLanguage;
		private int yearsOfExperience;

		private DotNetBuilder(String name, int level) {
			this.name = name;
			this.level = level;
			this.primaryLanguage = "ASP.NET Core";
			this.yearsOfExperience = 0;
		}

		public DotNetBuilder withPrimaryLanugage(String codingLanguage) {
			this.primaryLanguage = codingLanguage;
			return this;
		}

		public DotNetBuilder withYearsOfExperience(int years) {
			this.yearsOfExperience = years;
			return this;
		}

		public DotNetGroup build() {
			DotNetGroup dotNetDev = new DotNetGroup(this.name, this.level);
			dotNetDev.setPrimaryLanguage(primaryLanguage);
			dotNetDev.setYearsOfExperience(yearsOfExperience);
			return dotNetDev;
		}
	}



	@Override
	public double calculateSalary() {
		double baseSalary = 1400;
		int baseExperienceSalary = 100;
		double salary = baseSalary;
		salary += this.level*baseExperienceSalary;
		return salary;
	}


	@Override
	public void printMember(StaffPrinter printer) {
		printer.print("Name: " + getName() + "Level: " + level);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(level);
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
		DotNetGroup other = (DotNetGroup) obj;
		return level == other.level;
	}


	@Override
	public String toString() {
		return "DotNetGroup [" + super.toString() 
        + ", Level: " + level + "\n"
        + ", Primary Language: " + primaryLanguage + "\n"
        + ", Years of Experience: " + yearsOfExperience + "\n"
        + ", Members Count: " + members.size() + "]\n"; 	
	}
	
	/*
	 * Just for Builder
	 */	
	private void setPrimaryLanguage(String primaryLanguage) {
		this.primaryLanguage = primaryLanguage;
	}


	private void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}


	@Override
	public void join(Staff newMember) {
		if (newMember != null && !members.contains(newMember))
            members.addAll(members);
	}


	@Override
	public void leave(Staff newMember) {
		if (newMember != null && !members.contains(newMember))
			members.remove(newMember);
		
	}

	/*
	 * for testing
	 */

	int getLevel() {
		return level;
	}

	String getPrimaryLanguage() {
		return primaryLanguage;
	}

	int getYearsOfExperience() {
		return yearsOfExperience;
	}

	List<Staff> getMembers() {
		return members;
	}
	
	
	
	
}
