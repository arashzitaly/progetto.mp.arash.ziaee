package companyStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;

import company.utils.print.StaffPrinter;

public final class ProjectManager extends Staff {

    private Collection<Staff> groupMembers = new ArrayList<>();
    private String currentProject;

    private ProjectManager(String name) {
        super(name);
    }

    public static ProjectManagerBuilder newProjectManager(String name) {
        return new ProjectManagerBuilder(name);
    }

    public static class ProjectManagerBuilder {
        private String name;
        private Collection<Staff> members;

        private ProjectManagerBuilder(String name) {
            this.name = name;
            this.members = new ArrayList<>();
        }

        public ProjectManagerBuilder addMember(Staff member) {
            this.members.add(member);
            return this;
        }

        public ProjectManager build() {
            ProjectManager projectManager = new ProjectManager(this.name);
            projectManager.setMembers(this.members);
            return projectManager;
        }
    }

    @Override
    public void printMember(StaffPrinter printer) {
        printer.print("Project Manager: " + getName() + ", Assigned Project: " + currentProject);
        printer.print("Team Members:");
        for (Staff member : groupMembers) {
            printer.print(" - " + member.getName());
        }
    }

    @Override
    public double calculateSalary() {
        double baseSalary = 3000;
        int bonusPerDeveloper = 150;
        double salary = baseSalary + groupMembers.size() * bonusPerDeveloper;
        return salary;
    }
    
    @Override
	public void assignProject(String projectName) {
    	this.currentProject = projectName;
		/*this.currentProject = projectName;
		for (Staff member : groupMembers)
			member.assignProject(projectName);
			This implementation assign a projet to each developer member
			*/
	}


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), groupMembers);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProjectManager other = (ProjectManager) obj;
        return Objects.equals(groupMembers, other.groupMembers);
    }

    @Override
    public String toString() {
        return "Project Manager [" + super.toString() + ", Developers Managed: " + groupMembers.size() + "]";
    }
    
    
    /*
     * setter used inside the Builder class
     */
    
    private void setMembers(Collection<Staff> members) {
    	this.groupMembers = members;
    }
    
    // Methods to manage developers
    public void addMember(Staff developer) {
        groupMembers.add(developer);
    }

    public void removeMember(Staff developer) {
        groupMembers.remove(developer);
    }

    public Collection<Staff> getMembers() {
        return new ArrayList<>(groupMembers);
    }
    
    
    
}
