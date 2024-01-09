package company.utility.print;

import java.util.Iterator;

import company.Developers;
import company.ProjectManager;
import company.Staff;
import company.utility.StaffVisitor;

public class StaffListVisitor implements StaffVisitor{

	private StaffPrinter printer;
	
	public StaffListVisitor(StaffPrinter printer) {
		this.printer = printer;
	}

	@Override
	public void visitDeveloper(Developers developers) {
		printer.print("Developer Name : " + developers.getName());
	}

	@Override
	public void visitProjectManager(ProjectManager projectManager) {
		printer.print("Project Manager Name : " + projectManager.getName());
		Iterator<Staff> iterator = projectManager.iterator();
		while(iterator.hasNext()) {
			iterator.next().accept(this);
		}
	}
	
	
}
