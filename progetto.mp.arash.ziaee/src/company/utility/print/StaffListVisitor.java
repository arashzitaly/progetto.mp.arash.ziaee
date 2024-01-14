package company.utility.print;

import java.util.Iterator;

import company.Developers;
import company.ProjectManager;
import company.Staff;
import company.utility.StaffVisitor;

public class StaffListVisitor implements StaffVisitor{

	
	/*
	 * caso di un superiore una stampa di nome di tale oggetto e pure il nome di tutti i suoi figli ricorsivamente
	 */
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