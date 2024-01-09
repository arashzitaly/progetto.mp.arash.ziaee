package company.utility;

import company.Developers;
import company.ProjectManager;

public interface StaffVisitor {
	
	void visitDeveloper(Developers developers);
	void visitProjectManager(ProjectManager projectManager);

}
