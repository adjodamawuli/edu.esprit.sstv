package tn.esprit.sstvEJB.persistence.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Choice
 *
 */
@Entity

public class Choice implements Serializable {

	
	private int idChoice;
	private String responseChoice;
	private boolean stateChoice;
	
	
	private Question question;
	
	private static final long serialVersionUID = 1L;

	public Choice() {
		super();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdChoice() {
		return this.idChoice;
	}

	public void setIdChoice(int idChoice) {
		this.idChoice = idChoice;
	}   
	public String getResponseChoice() {
		return this.responseChoice;
	}

	public void setResponseChoice(String responseChoice) {
		this.responseChoice = responseChoice;
	}   
	public boolean getStateChoice() {
		return this.stateChoice;
	}

	public void setStateChoice(boolean stateChoice) {
		this.stateChoice = stateChoice;
	}
	@ManyToOne
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
   
}
