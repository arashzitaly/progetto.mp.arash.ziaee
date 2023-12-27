package companyStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import company.utils.print.StaffPrinter;

public final class ProjectManager extends Staff {

    private List<Developers> developers;

    private ProjectManager(String name) {
        super(name);
        this.developers = new ArrayList<>();
    }

    public static ProjectManagerBuilder newProjectManager(String name) {
        return new ProjectManagerBuilder(name);
    }

    public static class ProjectManagerBuilder {
        private String name;
        private List<Developers> developers;

        private ProjectManagerBuilder(String name) {
            this.name = name;
            this.developers = new ArrayList<>();
        }

        public ProjectManagerBuilder addDeveloper(Developers developer) {
            this.developers.add(developer);
            return this;
        }

        public ProjectManager build() {
            ProjectManager projectManager = new ProjectManager(this.name);
            projectManager.developers.addAll(this.developers);
            return projectManager;
        }
    }

    @Override
    public void printMember(StaffPrinter printer) {
        printer.print("Project Manager: " + getName());
        for (Developers developer : developers) {
            developer.printMember(printer);
        }
    }

    @Override
    public double calculateSalary() {
        double baseSalary = 3000;
        int bonusPerDeveloper = 150;
        double salary = baseSalary + developers.size() * bonusPerDeveloper;
        return salary;
    }

    // Methods to manage developers
    public void addDeveloper(Developers developer) {
        developers.add(developer);
    }

    public void removeDeveloper(Developers developer) {
        developers.remove(developer);
    }

    public List<Developers> getDevelopers() {
        return new ArrayList<>(developers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), developers);
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
        return Objects.equals(developers, other.developers);
    }

    @Override
    public String toString() {
        return "Project Manager [" + super.toString() + ", Developers Managed: " + developers.size() + "]";
    }
}
