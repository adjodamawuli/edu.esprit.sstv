package tn.esprit.sstvEJB.domain.ressourceManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.sstvEJB.domain.ressourceManagement.interfaces.RessourceManagementServicesLocal;
import tn.esprit.sstvEJB.domain.ressourceManagement.interfaces.RessourceManagementServicesRemote;
import tn.esprit.sstvEJB.persistence.entities.Choice;
import tn.esprit.sstvEJB.persistence.entities.Exam;
import tn.esprit.sstvEJB.persistence.entities.Question;

/**
 * Session Bean implementation class RessourceManagementServices
 */
@Stateless
public class RessourceManagementServices implements
		RessourceManagementServicesRemote, RessourceManagementServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	public RessourceManagementServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String prepareExam(List<Question> questions, String refExam,
			String nameExam) {
		Exam exam = new Exam();
		exam.setNameExam(nameExam);
		exam.setRefExam(refExam);
		exam.linkQuestionsToExam(questions);

		entityManager.persist(exam);
		return refExam;
	}

	@Override
	public void addQuestion(Question question) {
		entityManager.persist(question);
	}

	@Override
	public void addChoice(Choice choice) {
		entityManager.persist(choice);
	}

	@Override
	public void deleteChoice(Choice choice) {
		entityManager.remove(entityManager.merge(choice));

	}
}
