package company;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import company.utility.MockStaffPrinter;

public class ProjectManagerTest {

	private MockStaffPrinter printer;
    private ProjectManager projectManager;

    @Before
    public void SetUp() {
        printer = new MockStaffPrinter();

        ProjectManager softWareEngineer = ProjectManager.newProjectManager("Eugenio Ganghereti")
                                                            .build();

        projectManager = ProjectManager.newProjectManager("Ettore Etenzi")
                                       .addWorkingMembers(softWareEngineer)
                                       .addWorkingMembers(Developers.newDeveloper("Luca Gualandi", "BLOCKCHAIN")
                                                             .withContractType("FullTime")
                                                             .withYearsOfExperience(2)
                                                             .build())
                                       .addWorkingMembers(Developers.newDeveloper("Fabio Checcacci", "SQL")
                                                             .withContractType("FreeLancer")
                                                             .build())
                                       .build();
        
        projectManager.assignProject("TuscanyTouristicProject");
    }
    
    @Test
    public void testProjectManagerBuilder() {
        assertNotNull(projectManager);
        assertEquals("Ettore Etenzi", projectManager.getName());
        assertEquals(3, projectManager.getMembers().size());
    }
    
    @Test
    public void testProjectManagerNewBuilder() {
        ProjectManager manager = ProjectManager.newProjectManager("Cosimo Grazzini").build();
        assertNotNull(manager);
        assertEquals("Cosimo Grazzini", manager.getName());

        Developers developer = Developers.newDeveloper("Francesco Curcio", "Logistic")
                                         .withContractType("FullTime")
                                         .withYearsOfExperience(4)
                                         .build();
        assertNotNull(developer);
        assertEquals("Francesco Curcio", developer.getName());
        assertEquals("Logistic", developer.getGroup());
        assertEquals("FullTime", developer.getContract());
        assertEquals(4, developer.getYearsOfExperience());
    }


    @Test
    public void testProjectManagerPrintMember() {
        projectManager.printMember(printer);
        
        assertEquals("Project Manager: Ettore Etenzi\n"
        		+ "Assigned Project: TuscanyTouristicProject\n"
        		+ "Team Members:\n"
        		+ " - Eugenio Ganghereti\n"
        		+ " - Luca Gualandi\n"
        		+ " - Fabio Checcacci\n", printer.toString());
    }

    @Test
    public void testProjectManagerCalculateSalary() {
        double expectedSalary = 3000 + 3 * 150;
        assertEquals(expectedSalary, projectManager.calculateSalary(), 0.01);
    }

    @Test
    public void testProjectManagerAssignProject() {
        String projectName = "Bando Regione Toscana";
        projectManager.assignProject(projectName);
        assertEquals(projectName, projectManager.getCurrentProject());
    }

    @Test
    public void testProjectManagerToString() {
        assertEquals("Ettore Etenzi", projectManager.toString());
    }



    

}
