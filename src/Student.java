public class Student 
{
	private int studentId;
	private String answerSubmitted;

	//Student id is set
	public Student(int id) 
	{
		setStudentId(id);
	}

	//Stores a String in the field
	public void setStudentId(int id) 
	{
		studentId = id;
	}
	//Returns Student Object
	
	public void submitAnswer(String a) 
	{
		answerSubmitted = a;
	}

	public String getAnswerSubmitted() 
	{
		return answerSubmitted;
	}

	public int getStudentId() 
	{
		return studentId;
	}
}