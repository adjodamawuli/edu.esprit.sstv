package tn.esprit.sstv.test;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import tn.esprit.sstvEJB.domain.reporting.ReportingServicesRemote;
import tn.esprit.sstvEJB.persistence.entities.Choice;

public class TestDislayAllChoices {

	public TestDislayAllChoices() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			ReportingServicesRemote reportingServicesRemote = (ReportingServicesRemote) context
					.lookup("tn.esprit.sstv/tn.esprit.sstvEJB/ReportingServices!tn.esprit.sstvEJB.domain.reporting.ReportingServicesRemote");

			List<Choice> choices = reportingServicesRemote.displayAllChoices();
			System.out.println(choices.size());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
