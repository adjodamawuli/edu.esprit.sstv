package tn.esprit.sstvEJB.domain.reporting;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.sstvEJB.persistence.entities.Choice;

/**
 * Session Bean implementation class ReportingServices
 */
@Stateless
public class ReportingServices implements ReportingServicesRemote,
		ReportingServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ReportingServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Choice> displayAllChoices() {
		return entityManager.createQuery("select c from Choice c")
				.getResultList();
	}

	

}
