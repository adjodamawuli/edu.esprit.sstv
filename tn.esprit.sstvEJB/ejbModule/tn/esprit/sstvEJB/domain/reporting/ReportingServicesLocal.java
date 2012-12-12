package tn.esprit.sstvEJB.domain.reporting;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.sstvEJB.persistence.entities.Choice;

@Local
public interface ReportingServicesLocal {
	public List<Choice> displayAllChoices();
}
