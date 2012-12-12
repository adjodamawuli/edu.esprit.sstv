package tn.esprit.sstvEJB.domain.reporting;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.sstvEJB.persistence.entities.Choice;

@Remote
public interface ReportingServicesRemote {
	public List<Choice> displayAllChoices();
}
