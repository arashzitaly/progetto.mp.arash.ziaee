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
    public void testVisitProjectManagerWithDevelopers() {
        String projectName = "Open Source Optimization";
        ProjectManager manager = ProjectManager.newProjectManager("Ettore Etenzi")
                                               .addWorkingMembers(Developers.newDeveloper("Luca Gualandi", "BLOCKCHAIN")
                                                                     .withYearsOfExperience(0)
                                                                     .build())
                                               .addWorkingMembers(Developers.newDeveloper("Fabio Checcacci", "SQL")
                                                                     .withYearsOfExperience(0)
                                                                     .build())
                                               .build();
        manager.assignProject(projectName);
        manager.accept(visitor);

        assertEquals("Project Manager Name : Ettore Etenzi, Project :Open Source Optimization\n" +
                "Developer Name : Luca Gualandi, Group: BLOCKCHAIN, Years of Experience: 0\n" +
                "Developer Name : Fabio Checcacci, Group: SQL, Years of Experience: 0\n", printer.toString());
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
