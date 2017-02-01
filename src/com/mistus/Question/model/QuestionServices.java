package com.mistus.Question.model;

import java.util.List;



public class QuestionServices {
	
	private QuestionDAO_Hibernate QuestionDAO ;
	
	public QuestionServices(){
		
		 QuestionDAO = new QuestionDAO_Hibernate();
	}
	
	//1.AddQuestion
	public QuestionVO addQusetion(String question, String answer){
		
		QuestionVO questVO = new QuestionVO();
		
//		questVO.setQuestionNumber(2);
		questVO.setQuestion(question);
		questVO.setAnswer(answer);
		questVO.setCorrect(0);
		questVO.setWrong(0);
		
		QuestionDAO.Insert(questVO);
		
		return questVO;
	}
	
	//2.updataQusetion
	public QuestionVO updataQusetion(Integer questionNumber,String question,
			String answer, Integer correct, Integer wrong){
		
		QuestionVO questVO = new QuestionVO();
		questVO.setQuestionNumber(questionNumber);
		questVO.setQuestion(question);
		questVO.setAnswer(answer);
		questVO.setCorrect(correct);
		questVO.setWrong(wrong);
		
		QuestionDAO.Updata(questVO);
		return questVO;
	}
	
	public void Delete(Integer questionNumber) {
		// 
		QuestionDAO.delete(questionNumber);
	}
	
	public List<QuestionVO>getOne(Integer questionNumber){
		
		List<QuestionVO>list = QuestionDAO.getOne(questionNumber);
		
		return list;
	}
	
	public List<QuestionVO>getall(){
		
		List<QuestionVO>list = QuestionDAO.getAll();
		
		return list;
	}
	
    public List<QuestionVO>getAnalyticsQuestion(){
		
		List<QuestionVO>list = QuestionDAO.getAnalyticsQuestion();
		
		return list;
	}

    public List<QuestionVO>getCorrectQuestion(){
		
		List<QuestionVO>list = QuestionDAO.getCorrectQuestion();
		
		return list;
	}
	
  //追加新Service

    public List<QuestionVO>getCommandQuestion(String Command){
    	                                       
    		List<QuestionVO>list = QuestionDAO.getCommandQuestion(Command);
    		
    		return list;
    	}
    	
}
