package tn.esprit.sstv.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.sstvEJB.domain.ressourceManagement.interfaces.RessourceManagementServicesRemote;
import tn.esprit.sstvEJB.persistence.entities.Question;

public class TestAddQuestion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			RessourceManagementServicesRemote ressourceManagementServicesRemote = (RessourceManagementServicesRemote) context
					.lookup("ejb:tn.esprit.sstv/tn.esprit.sstvEJB/RessourceManagementServices!tn.esprit.sstvEJB.domain.ressourceManagement.interfaces.RessourceManagementServicesRemote");
			Question question = new Question();
			question.setContentQuestion("How old are you ? ");

			ressourceManagementServicesRemote.addQuestion(question);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
