package company;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import company.utility.MockStaffPrinter;

public class DevelopersTest {

    private Developers developers;

    @Before
    public void SetUp() {
        developers = Developers.newDeveloper("Alessio Taranto", ".Net")
                               .withContractType("Aprendistato")
                               .withYearsOfExperience(3)
                               .build();
    }

    @Test
    public void testDeveloperBuilder() {
        assertEquals("Alessio Taranto", developers.getName());
        assertEquals(".Net", developers.getGroup());
        assertEquals("Aprendistato", developers.getContract());
        assertEquals(3, developers.getYearsOfExperience());
    }

    @Test
    public void testPrintMember() {
        MockStaffPrinter printer = new MockStaffPrinter();
        developers.printMember(printer);

        String expectedOutput = "Name: Alessio Taranto, Group: .Net, Contract: Aprendistato, Years of Experience: 3\n";
        assertEquals(expectedOutput, printer.toString());
    }

    @Test
    public void testCalculateSalary() {
        double expectedSalary = 1400 + 3 * 100;
        assertEquals(expectedSalary, developers.calculateSalary(), 0.01);
    }

    @Test
    public void testAssignProject() {
        String projectName = "Project X";
        developers.assignProject(projectName);
        assertEquals(projectName, developers.getCurrentProject());
    }
    
    @Test
    public void testToStringMethod() {
        String expectedOutput = "[Developers Name = Alessio Taranto\n"
                                + ", Group: .Net\n"
                                + ", Contract Type: Aprendistato\n"
                                + ", Years of Experience: 3\n"
                                + ", Current Project: null]\n";
        assertEquals(expectedOutput, developers.toString());
    }


    
    
    
    
    
}
