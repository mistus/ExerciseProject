package com.mistus.Question.model;

public class Question_TEST {

	public static void main(String[] args) {
		
			
		QuestionServices QS = new QuestionServices();		
		
		String Command = "from QuestionVO where questionNumber = 1";
		Command = "update QuestionVO set question = '1', answer = '2', correct = '1', wrong ='2' where questionNumber ='3'";

//		String Command = "DeLete from QuestionVO where questionNumber =1";
		//QS.getCommandQuestion(Command);
		
		//１.ADDＯＫ
//		QS.addQusetion("CoCo", "飲料店");

		//2.OK
//		QS.updataQusetion(1, "CoCo", "飲料店", 1, 0);
		
		//3.OK
//		QS.Delete(2);
		
		//4.OK
//		QS.getall();
		
		//5.OK
//		QS.getOne(1);
		
		//6、7OK
	
		for(QuestionVO Question:QS.getCorrectQuestion()){
			
			System.out.println(Question.getQuestion());
			System.out.println(Question.getAnswer());
			System.out.println(Question.getCorrect());
			System.out.println(Question.getWrong());
		}
		
		
		//8.亂數測試
		
//		QuestionServlet QS = new QuestionServlet();
		
		
	}
	
}
