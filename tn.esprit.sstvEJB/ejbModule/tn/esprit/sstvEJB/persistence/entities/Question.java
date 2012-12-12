package tn.esprit.sstvEJB.persistence.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Question
 *
 */
@Entity

public class Question implements Serializable {

	
	private int idQuestion;
	private String contentQuestion;
	private String typeQuestion;
	private int levelQuestion;
	private float scaleQuestion;
	
	private List<Choice> choices;	
	private Exam exam;
	
	private static final long serialVersionUID = 1L;

	public Question() {
		super();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}   
	public String getContentQuestion() {
		return this.contentQuestion;
	}

	public void setContentQuestion(String contentQuestion) {
		this.contentQuestion = contentQuestion;
	}   
	public String getTypeQuestion() {
		return this.typeQuestion;
	}

	public void setTypeQuestion(String typeQuestion) {
		this.typeQuestion = typeQuestion;
	}   
	public int getLevelQuestion() {
		return this.levelQuestion;
	}

	public void setLevelQuestion(int levelQuestion) {
		this.levelQuestion = levelQuestion;
	}   
	public float getScaleQuestion() {
		return this.scaleQuestion;
	}

	public void setScaleQuestion(float scaleQuestion) {
		this.scaleQuestion = scaleQuestion;
	}
	@OneToMany(mappedBy="question",cascade=CascadeType.PERSIST)
	public List<Choice> getChoices() {
		return choices;
	}
	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}
	@ManyToOne
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public void linkChoicesToQuestion(List<Choice> choices){
		for(Choice c : choices){
			c.setQuestion(this);
		}
		this.setChoices(choices);
	}
   
}
