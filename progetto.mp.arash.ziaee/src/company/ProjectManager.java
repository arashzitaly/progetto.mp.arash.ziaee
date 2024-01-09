package company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

import company.utility.StaffVisitor;
import company.utility.print.StaffPrinter;

public final class ProjectManager extends Staff {

    private Collection<Staff> developersMember = new ArrayList<>();
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

        public ProjectManagerBuilder addMembers(Staff developer) {
            this.members.add(developer);
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
        printer.print("Project Manager: " + getName() + "\nAssigned Project: " + currentProject);
        printer.print("Team Members:");
        for (Staff member : developersMember) {
            printer.print(" - " + member.getName());
        }
    }

    @Override
    public double calculateSalary() {
        double baseSalary = 3000;
        int bonusPerDeveloper = 150;
        double salary = baseSalary + developersMember.size() * bonusPerDeveloper;
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
    public void accept(StaffVisitor visitor) {
    	visitor.visitProjectManager(this);
    }
    
    public Iterator<Staff> iterator(){
    	return developersMember.iterator();
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), developersMember);
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
        return Objects.equals(developersMember, other.developersMember);
    }

    @Override
    public String toString() {
        return "" + this.getName();
    }
    
    
    /*
     * setter used inside the Builder class
     */
    
    private void setMembers(Collection<Staff> members) {
    	this.developersMember = members;
    }
    
    
    
    /* 
     * Methods to manage developers
     */
    public void addMembers(Staff developer) {
        developersMember.add(developer);
    }

    public void removeMembers(Staff developer) {
        developersMember.remove(developer);
    }

    public Collection<Staff> getMembers() {
        return developersMember;
    }

	public String getCurrentProject() {
		return currentProject;
	}
    
    
    
    
}
