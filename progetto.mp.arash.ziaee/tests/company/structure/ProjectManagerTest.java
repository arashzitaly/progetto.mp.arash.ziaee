package company.structure;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import companyStructure.ProjectManager;
import companyStructure.Staff;
import companyStructure.Developers;
import company.utils.print.StaffPrinter;

public class ProjectManagerTest {

    private ProjectManager projectManager;
    private Staff developer1, developer2;

    @Before
    public void setUp() {
        // Using DeveloperBuilder to create developer instances
        developer1 = Developers.newDeveloper("Bob", "Development Group")
                            .withContractType("Full-Time")
                            .withYearsOfExperience(5)
                            .build();

        developer2 = Developers.newDeveloper("Charlie", "Development Group")
                            .withContractType("Part-Time")
                            .withYearsOfExperience(3)
                            .build();

        projectManager = ProjectManager.newProjectManager("Alice")
                                       .addMember(developer1)
                                       .addMember(developer2)
                                       .build();
    }

    @Test
    public void testAddAndRemoveMember() {
        assertEquals(2, projectManager.getMembers().size());
        
        projectManager.removeMember(developer1);
        assertEquals(1, projectManager.getMembers().size());

        projectManager.addMember(developer1);
        assertEquals(2, projectManager.getMembers().size());
    }

    @Test
    public void testAssignProject() {
        projectManager.assignProject("Project X");
        assertEquals("Project X", projectManager.getCurrentProject());
    }

    @Test
    public void testCalculateSalary() {
        double expectedSalary = 3000 + (2 * 150); // Base salary + bonus for each developer
        assertEquals(expectedSalary, projectManager.calculateSalary(), 0.01);
    }

    @Test
    public void testPrintMember() {
        // Assume StaffPrinter and mock setup as in the previous example
    }

    // Other tests...
}
