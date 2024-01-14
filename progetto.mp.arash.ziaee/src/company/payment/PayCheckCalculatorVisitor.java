package company.payment;

import company.Developers;
import company.ProjectManager;
import company.utility.StaffVisitor;

public class PayCheckCalculatorVisitor implements StaffVisitor {
	
	private PayingSystem payment;
		

	public PayCheckCalculatorVisitor(PayingSystem payment) {
		this.payment = payment;
	}


	@Override
	public void visitDeveloper(Developers developers) {
		this.payment.renderPayCheck(developers, developers.calculateSalary());
	}


	@Override
	public void visitProjectManager(ProjectManager projectManager) {
		this.payment.renderPayCheck(projectManager, projectManager.calculateSalary());
		projectManager.applyOnDevelopers(dev -> dev.accept(this));
	}

}
