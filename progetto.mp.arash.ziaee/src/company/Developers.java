package company;

import java.util.Objects;

import company.print.StaffPrinter;
import company.visitor.StaffVisitor;

public class Developers extends Staff {
    
    private String workingGroup;
    private String contract;
    private int yearsOfExperience;
    
    private String currentProject;

    private Developers(String name, String workingGroup) {
        super(name);
        this.workingGroup = workingGroup;
    }
    
    public static DeveloperBuilder newDeveloper(String name, String group) {
    	return new DeveloperBuilder(name, group);
    }
    
    public static class DeveloperBuilder {
        private String name;
        private String workingGroup;
        private String contractType = "Not Mentioned";
        private Integer yearsOfExperience  = 0;

        private DeveloperBuilder(String name, String group) {
            this.name = name;
            this.workingGroup = group;
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
            Developers developer = new Developers(this.name, this.workingGroup);
            developer.setContract(contractType);
            developer.setYearsOfExperience(yearsOfExperience);
            return developer;
        }
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
        						+ ", Group: " + workingGroup 
        						+ ", Contract: " + contract 
        						+ ", Years of Experience: " + yearsOfExperience);
    }
    
    @Override
    public void accept(StaffVisitor visitor) {
    	visitor.visitDeveloper(this);
    }
    
    @Override
	public void assignProject(String projectName) {
		this.currentProject = projectName;		
	}
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(contract, currentProject, workingGroup, yearsOfExperience);
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
		return Objects.equals(contract, other.contract) && Objects.equals(currentProject, other.currentProject)
				&& Objects.equals(workingGroup, other.workingGroup) && yearsOfExperience == other.yearsOfExperience;
	}

	@Override
	public String toString() {
	    return "[" + super.toString() 
	           + ", Group: " + workingGroup + "\n"
	           + ", Contract Type: " + contract + "\n"
	           + ", Years of Experience: " + yearsOfExperience + "\n"
	           + ", Current Project: " + currentProject + "]\n";
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
		return workingGroup;
	}

	public String getContract() {
		return contract;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	
	public String getCurrentProject() {
	    return currentProject;
	}


    
    
}
