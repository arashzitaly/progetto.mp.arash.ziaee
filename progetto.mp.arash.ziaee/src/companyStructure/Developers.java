package companyStructure;

import java.util.Objects;

import company.utils.print.StaffPrinter;

public class Developers extends Staff {
    
    private String group;
    private String contract;
    private int yearsOfExperience;

    private Developers(String name, String group) {
        super(name);
        this.group = group;
    }

    
    
    public static DeveloperBuilder newDeveloper(String name, String group) {
    	return new DeveloperBuilder(name, group);
    }
    
    public static class DeveloperBuilder {
        private String name;
        private String group;
        private String contractType = "Not Mentioned";
        private Integer yearsOfExperience = 0;

        public DeveloperBuilder(String name, String group) {
            this.name = name;
            this.group = group;
        }

        public DeveloperBuilder withContractType(String contractType) {
            this.contractType = contractType;
            return this;
        }

        public DeveloperBuilder withYearsOfExperience(int yearsOfExperience) {
            this.yearsOfExperience = yearsOfExperience;
            return this;
        }

        public Developers build() {
            Developers developer = new Developers(this.name, this.group);
            developer.setContract(contractType);
            developer.setYearsOfExperience(yearsOfExperience);
            return developer;
        }
    }
    
    @Override
    public void join(Staff group) {
        // Implementation logic
    }


	@Override
    public void leave(Staff group) {
        // Implementation logic
    }

    @Override
    public double calculateSalary() {
       double baseSalary = 1400;
       int experienceAdditional = 100;
       double salary = baseSalary;
       salary += this.yearsOfExperience * experienceAdditional;
       return salary;
    }

    @Override
    public void printMember(StaffPrinter printer) {
        printer.print("Name: " + getName() 
        						+ ", Group: " + group 
        						+ ", Contract: " + contract 
        						+ ", Years of Experience: " + yearsOfExperience);
    }
    
    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(yearsOfExperience);
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
		return yearsOfExperience == other.yearsOfExperience;
	}

	@Override
	public String toString() {
	    return "Developer [" + super.toString() 
	           + ", Group: " + group + "\n"
	           + ", Contract Type: " + contract + "\n"
	           + ", Years of Experience: " + yearsOfExperience + "]";
	}




	/*
     * private, for Builder Method
     */
	private void setContract(String contract) {
		this.contract = contract;
	}

	private void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}


	/*
	 *  just for tests 
	 */

	public String getGroup() {
		return group;
	}


	public String getContract() {
		return contract;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

    
    
}
