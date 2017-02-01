package com.mistus.Question.model;

public class QuestionVO {

	private Integer questionNumber;
	private String question;
	private String answer;
	private Integer correct;
	private Integer wrong;
	
	
	
	public Integer getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(Integer questionNumber) {
		this.questionNumber = questionNumber;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Integer getCorrect() {
		return correct;
	}
	public void setCorrect(Integer correct) {
		this.correct = correct;
	}
	public Integer getWrong() {
		return wrong;
	}
	public void setWrong(Integer wrong) {
		this.wrong = wrong;
	}
	
	
}
