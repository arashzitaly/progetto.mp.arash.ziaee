package company;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
    
    @Test
    public void testIteratorProjectManager() {
        Iterator<Staff> iterator = projectManager.iterator();
        assertNotNull(iterator);

        Set<String> foundMemberNames = new HashSet<>();

        while (iterator.hasNext()) {
            Staff member = iterator.next();
            foundMemberNames.add(member.getName());
        }

        Set<String> expectedNames = new HashSet<>(Arrays.asList("Eugenio Ganghereti", "Luca Gualandi", "Fabio Checcacci"));
        assertEquals(expectedNames, foundMemberNames);
    }
    
    @Test
    public void testAddMembers() {
        Developers newDeveloper = Developers.newDeveloper("Giovanni Verdi", "BLOCKCHAIN")
                                            .withContractType("PartTime")
                                            .build();
        
        int sizeBeforeAdd = projectManager.getMembers().size();
        
        List<Staff> newMembers = Arrays.asList(newDeveloper);
        projectManager.addMembers(newMembers);
        
        int sizeAfterAdd = projectManager.getMembers().size();
        
        assertEquals(sizeBeforeAdd + 1, sizeAfterAdd);
        assertTrue(projectManager.getMembers().contains(newDeveloper));
    }

    /*
	 * Helper method for testing removeMemeber method
	 */
	private Staff findMemberByName(String name) {
	    for (Staff member : projectManager.getMembers()) {
	        if (member.getName().equals(name)) {
	            return member;
	        }
	    }
	    return null;
	}
    @Test
    public void testRemoveMembers() {
        Staff existingMember = findMemberByName("Fabio Checcacci");
        assertNotNull(existingMember);

        int originalSize = projectManager.getMembers().size();
        List<Staff> toBeRemovedMember = Arrays.asList(existingMember);
        projectManager.removeMembers(toBeRemovedMember);

        assertEquals(originalSize - 1, projectManager.getMembers().size());
        assertFalse(projectManager.getMembers().contains(existingMember));
    }
    

}
