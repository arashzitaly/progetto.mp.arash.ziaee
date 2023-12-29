package company.structure;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.annotation.processing.SupportedAnnotationTypes;

import companyStructure.ProjectManager;
import companyStructure.Staff;
import companyStructure.Developers;
import company.utils.MockStaffPrinter;
import company.utils.print.StaffPrinter;

public class ProjectManagerTest {

	private MockStaffPrinter printer;
    private ProjectManager projectManager;

    @Before
    public void setUp() {
    	printer = new MockStaffPrinter();
    	projectManager = ProjectManager.newProjectManager("Andrea Checcacci")
    									.addMembers(ProjectManager.newProjectManager("Daniele Casebasse")
    									.build())
    									
    								.addMembers(Developers
    											.newDeveloper("Alessio Taranto", ".Net")
    											.withContractType("Apparentship")
    											.withYearsOfExperience(3)
    											.build())
    								.build();
    	projectManager.assignProject("Pisa Rail Station");
    }
    
    
    @Test
    public void testAddProjectManager() {
    	projectManager = ProjectManager.newProjectManager("Giovanni Galeazzi").build();
    	Developers devs = Developers.newDeveloper("Luca Gualandi", "BlockChain")
    										.withYearsOfExperience(2)
    										.build();
    	
    	projectManager.addMembers(devs);
    	
    	assertEquals(projectManager.getMembers().size(),
    			1);
    	assertTrue(projectManager.getMembers().contains(devs));
    }
    
    @Test
    public void testRemoveProjectManager() {
    	ProjectManager forRemove = ProjectManager.newProjectManager("Francesco Persiano").build();
    	
    	projectManager.removeMembers(forRemove);
    	
    	assertEquals(projectManager.getMembers().size(),2);
    	assertFalse(projectManager.getMembers().contains(forRemove));
    }
    
    @Test
    public void testCalculateSalary() {
        assertEquals(projectManager.calculateSalary(),
        		projectManager.calculateSalary(), 0.01);
    }
    
    @Test
    public void testProjectManagerPrintMembers() {
    	projectManager.printMember(printer);

    	assertEquals( "Project Manager: Andrea Checcacci\n"+
                "Assigned Project: Pisa Rail Station\n"+
    			"Team Members:\n"+ 
                " - Daniele Casebasse\n"+ 
    			" - Alessio Taranto\n",
                printer.toString());
    }
    
    @Test
    public void testToStringProjectManager() {
    	assertEquals("Andrea Checcacci",
    			projectManager.toString());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
