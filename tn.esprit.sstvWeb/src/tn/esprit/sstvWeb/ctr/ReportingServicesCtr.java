package tn.esprit.sstvWeb.ctr;

import java.util.ArrayList;
import java.util.List;

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
public class ReportingServicesCtr {
	private List<Choice> choices = new ArrayList<Choice>();
	private DataModel<Choice> dataModel = new ListDataModel<Choice>();
	@EJB
	private ReportingServicesLocal reportingServicesLocal;
	@EJB
	private RessourceManagementServicesLocal ressourceManagementServicesLocal;

	public String doDeleteChoice() {
		Choice choiceTMP = dataModel.getRowData();
		ressourceManagementServicesLocal.deleteChoice(choiceTMP);
		return "ok";
	}

	public List<Choice> getChoices() {
		choices = reportingServicesLocal.displayAllChoices();
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	public DataModel<Choice> getDataModel() {
		dataModel.setWrappedData(reportingServicesLocal.displayAllChoices());
		return dataModel;
	}

	public void setDataModel(DataModel<Choice> dataModel) {
		this.dataModel = dataModel;
	}

}
