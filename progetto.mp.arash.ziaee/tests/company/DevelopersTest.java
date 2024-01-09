package company;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import company.Developers;
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

		String expectedOutput = "Name: Alessio Taranto, Group: .Net, Contract: Aprendistato, Years of Experience: 3";
		assertEquals(expectedOutput, printer.toString().trim());
	}


}
