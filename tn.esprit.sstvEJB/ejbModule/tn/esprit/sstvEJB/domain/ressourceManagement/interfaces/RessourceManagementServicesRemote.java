package tn.esprit.sstvEJB.domain.ressourceManagement.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.sstvEJB.persistence.entities.Choice;
import tn.esprit.sstvEJB.persistence.entities.Question;

@Remote
public interface RessourceManagementServicesRemote {
	public String prepareExam(List<Question> questions,String refExam,String nameExam);
	public void addQuestion(Question question);
	public void addChoice(Choice choice);
	

}
