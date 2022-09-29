public class SingleChoice extends Question
{
	private String correctAnswer;
	
	public SingleChoice(String que)
	{
		setQuestion(que);
	}
	
	public SingleChoice(String que, String[] options, String solution)
	{
		setQuestion(que);
		setAnswerChoices(options);
		solution = correctAnswer;
	}
	
	public void setCorrectAnswer(String answer)
	{
		correctAnswer = answer;
	}
	
	public String getCorrectAnswer()
	{
		return correctAnswer;
	}
	
	public int getNumberOfCorrectAnswers()
	{
		return 1;
	}
}
