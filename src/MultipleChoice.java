public class MultipleChoice extends Question
{

	private String[] correctAnswers;
	
	public void setCorrectAnswer(String[] answer)
	{
		correctAnswers = answer;
	}
	
	public String getCorrectAnswer()
	{
		String answer = "";
		for(int i = 0; i < correctAnswers.length; i++)
		{
			answer = answer + correctAnswers[i] + " ";
		}
		return answer;
	}
	
	public int getNumberOfCorrectAnswers()
	{
		return correctAnswers.length;
	}
	
	public MultipleChoice(String que)
	{
		setQuestion(que);
	}
	
	public MultipleChoice(String que, String[] options, String[] solution)
	{
		setQuestion(que);
		setAnswerChoices(options);
		correctAnswers = solution;
	}
	
}