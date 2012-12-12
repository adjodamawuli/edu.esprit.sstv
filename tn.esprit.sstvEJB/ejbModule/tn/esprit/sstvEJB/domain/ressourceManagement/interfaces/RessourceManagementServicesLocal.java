package tn.esprit.sstvEJB.domain.ressourceManagement.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.sstvEJB.persistence.entities.Choice;
import tn.esprit.sstvEJB.persistence.entities.Question;

@Local
public interface RessourceManagementServicesLocal {
	public String prepareExam(List<Question> questions, String refExam,
			String nameExam);

	public void addQuestion(Question question);

	public void addChoice(Choice choice);

	public void deleteChoice(Choice choice);

}
