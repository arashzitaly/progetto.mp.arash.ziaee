package company.structure;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import company.utils.MockStaffPrinter;
import companyStructure.DotNetGroup;

public class DotNetGroupTest {
    
    private DotNetGroup dotNetGroup;

    @Before
    public void setup() {
        dotNetGroup = DotNetGroup.newDotNetMember("Alessio Taranto", 3)
        							.withPrimaryLanugage(".Net Core")
        							.withYearsOfExperience(4)
        							.build();
    }
    
    @Test
    public void testDotNetbuilder() {
    	assertEquals("Alessio Taranto", dotNetGroup.getName());
    }
    
    @Test
    public void testDotNetMemberCalculateSalary() {
    	double expectedSalary = 1700;
    	assertEquals(expectedSalary, dotNetGroup.calculateSalary(), 0.01);
    }
    
     @Test
     public void testPrinMemberDotNet() {
    	 MockStaffPrinter printer = new MockStaffPrinter();
    	 dotNetGroup.printMember(printer);
    	 assertEquals("Name: Alessio Taranto, Level: 3", printer.toString().trim());
     }
    
}
