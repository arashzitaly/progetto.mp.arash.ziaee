package companyStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import company.utils.print.StaffPrinter;

public final class ProjectManager extends Staff {

    private Collection<Staff> groupMembers = new ArrayList<>();

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
        printer.print("Project Manager: " + getName());
         groupMembers.forEach(resource -> resource.printMember(printer));
        
    }

    @Override
    public double calculateSalary() {
        double baseSalary = 3000;
        int bonusPerDeveloper = 150;
        double salary = baseSalary + groupMembers.size() * bonusPerDeveloper;
        return salary;
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

    public Collection<Staff> getMember() {
        return new ArrayList<>(groupMembers);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
