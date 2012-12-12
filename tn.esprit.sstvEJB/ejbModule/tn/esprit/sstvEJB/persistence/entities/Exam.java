package tn.esprit.sstvEJB.persistence.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Exam
 *
 */
@Entity

public class Exam implements Serializable {

	
	private String refExam;
	private String nameExam;
	private String natureExam;
	
	private List<Question>questions;
	
	private static final long serialVersionUID = 1L;

	public Exam() {
		super();
	}   
	@Id    
	public String getRefExam() {
		return this.refExam;
	}

	public void setRefExam(String refExam) {
		this.refExam = refExam;
	}   
	public String getNameExam() {
		return this.nameExam;
	}

	public void setNameExam(String nameExam) {
		this.nameExam = nameExam;
	}   
	public String getNatureExam() {
		return this.natureExam;
	}

	public void setNatureExam(String natureExam) {
		this.natureExam = natureExam;
	}
	@OneToMany(mappedBy="exam",cascade=CascadeType.PERSIST)
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public void linkQuestionsToExam(List<Question> questions){
		for(Question q: questions){
			q.setExam(this);
		}
		this.setQuestions(questions);
	}
   
}
