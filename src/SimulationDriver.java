import java.util.*;

public class SimulationDriver 
{

	public static void main(String[] args) 
	{

		VotingService v = new VotingService();
		Random rand = new Random();
		
		//Create 10 students with unique ids and add to participants list
		for(int j = 0; j < 10; j++)
		{
			Student s = new Student(rand.nextInt(9999));
			for(int i = 0; i < v.getNumParticipants(); i++)
			{
				if(s.getStudentId() == v.getParticipantAt(i).getStudentId())
				{
					s.setStudentId(rand.nextInt());
				}
				
			}
			v.addParticipant(s);
		}
		
		startSimulation(v);
		
		for(int k = 0; k < v.getNumberOfQuestions(); k++)
		{
			System.out.println(v.askQuestion(k));
			participantsAnswer(v,k);
			v.displayResults(v.getCorrectAnswer(v.getQuestionAt(k)));
		}
		
	}
	
	public static void startSimulation(VotingService v)
	{
		SingleChoice q1 = new SingleChoice("Who won Worlds 2019");
		String[] q1Choices = {"TSM","FPX","DWG","DFM"};
		q1.setAnswerChoices(q1Choices);
		q1.setCorrectAnswer("FPX");
		v.addQuestion(q1);
		
		SingleChoice q2 = new SingleChoice("Students never procrastinate");
		String[] q2Choices = {"True","False"};
		q2.setAnswerChoices(q2Choices);
		q2.setCorrectAnswer("False");
		v.addQuestion(q2);
		
		MultipleChoice q3 = new MultipleChoice("Which Tokusatsu shows were on air August 2018?");
		String[] q3Choices = {"Kamen Rider Zi-O","Lupinranger VS Patranger","Kamen Rider Decade","Kishiryu Sentai Ryusoulger"};
		String[] q3Answers = {"Kamen Rider Zi-O","Lupinranger VS Patranger"};
		q3.setAnswerChoices(q3Choices);
		q3.setCorrectAnswer(q3Answers);
		v.addQuestion(q3);
		
	}
	
	public static void participantsAnswer(VotingService v, int questionIndex)
	{
		Random rand = new Random();
		char answer;
		
		for(int i = 0; i < v.getNumParticipants(); i++)
		{
			if(v.getQuestionAt(questionIndex).getNumberOfCorrectAnswers() > 1)
			{
				String s;
				answer = (char)(65 + rand.nextInt(v.getQuestionAt(questionIndex).getNumberOfAnswerChoices()));
				s = String.valueOf(answer) + " ";
				answer = (char)(65 + rand.nextInt(v.getQuestionAt(questionIndex).getNumberOfAnswerChoices()));
				s = s + String.valueOf(answer);
				v.submitAnswer(v.getParticipantAt(i).getStudentId(), s);
			}
			else
			{
			    answer = (char)(65 + rand.nextInt(v.getQuestionAt(questionIndex).getNumberOfAnswerChoices()));
			    v.submitAnswer(v.getParticipantAt(i).getStudentId(), String.valueOf(answer));
			}
		}
		//participant at index 0 resubmits "A" as an answer
	v.submitAnswer(v.getParticipantAt(0).getStudentId(),"A");
	}

}
