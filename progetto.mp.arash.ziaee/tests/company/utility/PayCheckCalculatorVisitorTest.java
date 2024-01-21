package company.utility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import company.Developers;
import company.ProjectManager;
import company.payment.PayCheckCalculatorVisitor;

public class PayCheckCalculatorVisitorTest {

	private PayCheckCalculatorVisitor salaryVisitor;
	private MockPayCheckSystem payingSystem;

	@Before
	public void SetUp() {
		payingSystem = new MockPayCheckSystem();
		salaryVisitor = new PayCheckCalculatorVisitor(payingSystem);
	}

	@Test
	public void testSoloDeveloperPayment() {
		Developers developer = Developers.newDeveloper("Dino Jelic", "DevOps")
				.withYearsOfExperience(5)							
				.build();
		developer.accept(salaryVisitor);
		assertEquals(developer.calculateSalary(),
				payingSystem.getSalary(developer), 0.1);
	}

	@Test
	public void testSoloProjectManagerPayment() {
		ProjectManager soloManager = ProjectManager.newProjectManager("Francesco Venturi").build();
		soloManager.accept(salaryVisitor);

		assertEquals(soloManager.calculateSalary(),
				payingSystem.getSalary(soloManager), 0.1);
	}

	@Test
	public void testProjectManagerWithDevelopersPayment() {
		ProjectManager manager = ProjectManager.newProjectManager("Luca Neri")
				.addWorkingMembers(Developers.newDeveloper("Sara Rossi",
						"Front-End").build())
				.addWorkingMembers(Developers.newDeveloper("Giulia Verdi",
						"Back-End").build())
				.build();
		manager.accept(salaryVisitor);

		assertEquals(manager.calculateSalary(),
				payingSystem.getSalary(manager), 0.01);
	}

}
