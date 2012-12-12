package tn.esprit.sstv.test;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.sstvEJB.domain.ressourceManagement.interfaces.RessourceManagementServicesRemote;
import tn.esprit.sstvEJB.persistence.entities.Choice;
import tn.esprit.sstvEJB.persistence.entities.Question;

public class TestPrepareExam {

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

			Choice choice = new Choice();
			choice.setResponseChoice("20");
			choice.setStateChoice(false);

			Choice choice2 = new Choice();
			choice2.setResponseChoice("25");
			choice2.setStateChoice(true);

			Choice choice3 = new Choice();
			choice3.setResponseChoice("30");
			choice3.setStateChoice(false);

			List<Choice> choices = new ArrayList<Choice>();
			choices.add(choice);
			choices.add(choice2);
			choices.add(choice3);

			question.linkChoicesToQuestion(choices);

			List<Question> questions = new ArrayList<Question>();
			questions.add(question);

			ressourceManagementServicesRemote.prepareExam(questions, "ESP001",
					"Jee");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
