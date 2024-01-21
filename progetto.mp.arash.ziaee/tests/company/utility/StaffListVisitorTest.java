package company.utility;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import company.Developers;
import company.ProjectManager;
import company.utility.print.StaffListVisitor;

public class StaffListVisitorTest {


    private MockStaffPrinter printer;
    private StaffVisitor visitor;

    @Before
    public void setUp() {
        printer = new MockStaffPrinter();
        visitor = new StaffListVisitor(printer);
    }

    @Test
    public void testVisitSoloDeveloper() {
        Developers developer = Developers.newDeveloper("Tania Bruno", "Front-End")
                                         .withYearsOfExperience(3)
                                         .build();
        developer.accept(visitor);

        assertEquals("Developer Name : Tania Bruno, Group: Front-End, Years of Experience: 3\n",
        		printer.toString());
    }
    
    @Test
    public void testVisitSoloProjectManager() {
        String projectName = "Misericordia Firenze";
        ProjectManager soloManager = ProjectManager.newProjectManager("Franklin Tavarez").build();
        soloManager.assignProject(projectName);
        soloManager.accept(visitor);

        assertEquals("Project Manager Name : Franklin Tavarez, Project : Misericordia Firenze\n",
        		printer.toString());
    }

    @Test
    public void testVisitProjectManagerWithDevelopers() {
        String projectName = "Open Source Optimization";
        ProjectManager softWareEngineer = ProjectManager.newProjectManager("Eugenio Ganghereti")
                .build();
        
        ProjectManager manager = ProjectManager.newProjectManager("Ettore Etenzi")
        									   .addWorkingMembers(softWareEngineer)
                                               .addWorkingMembers(Developers.newDeveloper("Luca Gualandi",
                                            		   				"BLOCKCHAIN")
                                                                     .withYearsOfExperience(0)
                                                                     .build())
                                               .addWorkingMembers(Developers.newDeveloper("Fabio Checcacci",
                                            		   				"SQL")
                                                                     .withYearsOfExperience(0)
                                                                     .build())
                                               .build();
        manager.assignProject(projectName);
        manager.accept(visitor);

        assertEquals("Project Manager Name : Ettore Etenzi, Project : Open Source Optimization\n" +
        		"Project Manager Name : Eugenio Ganghereti, Project : Open Source Optimization\n"+
                "Developer Name : Luca Gualandi, Group: BLOCKCHAIN, Years of Experience: 0\n" +
                "Developer Name : Fabio Checcacci, Group: SQL, Years of Experience: 0\n",
                printer.toString());
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
