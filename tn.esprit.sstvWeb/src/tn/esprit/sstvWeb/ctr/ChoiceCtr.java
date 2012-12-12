package tn.esprit.sstvWeb.ctr;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import tn.esprit.sstvEJB.domain.reporting.ReportingServicesLocal;
import tn.esprit.sstvEJB.domain.ressourceManagement.interfaces.RessourceManagementServicesLocal;
import tn.esprit.sstvEJB.persistence.entities.Choice;

@ManagedBean
@SessionScoped
// permet de resourdre le prob de detached car @sessionScoped on pe pas faire 2
// ajouts sucessif
public class ChoiceCtr {
	// model
	private Choice choice = new Choice();
	private DataModel<Choice> dataModel = new ListDataModel<Choice>();

	// injection of proxy
	@EJB
	private RessourceManagementServicesLocal ressourceManagementServicesLocal;
	private ReportingServicesLocal reportingServicesLocal;

	// methods
	public String doAddChoice() {
		ressourceManagementServicesLocal.addChoice(choice);
		return "";
	}

	

	public ChoiceCtr() {
	}

	public Choice getChoice() {
		return choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}

	public DataModel<Choice> getDataModel() {
		dataModel.setWrappedData(reportingServicesLocal.displayAllChoices());
		return dataModel;
	}

	public void setDataModel(DataModel<Choice> dataModel) {
		this.dataModel = dataModel;
	}

}
