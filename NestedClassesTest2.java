package nestedclass;

public class NestedClassesTest2 {

	public static void main(String[] args) {
		Exam e1 = new Exam("MCQ", "university exam", 100);
		e1.attempExam();

	}

}


class Exam
{
	String type; //MCQ, Theorotical, both
	String examName;
	int noOfStudentsAppearing;
	int marks;
	
	private HallTicket ht = new HallTicket("CN",  "Mansi", "pune" ,101 , 1);
	
	
	public Exam(String type, String examName, int noOfStudentsAppearing) {
		super();
		this.type = type;
		this.examName = examName;
		this.noOfStudentsAppearing = noOfStudentsAppearing;
		
	}



	void attempExam()
	{
		System.out.println("attempting the exam.....");
		if(ht.getIsIssued() == 1)
		{
			System.out.println("Yon can appear for the exam");
		}
		else
		{
			//throw new HallTicketNotIssuedYet("Please collect the hall ticket first");
		}
	}

	
	
	class HallTicket
	{
		String subjectName;
		String studentName;
		String examCenter;
		int rollNo;
		int isIssued;
		
		public HallTicket(String subjectName, String studentName, String examCenter, int rollNo, int isIssued) {
			super();
			this.subjectName = subjectName;
			this.studentName = studentName;
			this.examCenter = examCenter;
			this.rollNo = rollNo;
			this.isIssued = isIssued;
		}
		
		public String getSubjectName() {
			return subjectName;
		}
		public void setSubjectName(String subjectName) {
			this.subjectName = subjectName;
		}
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		public String getExamCenter() {
			return examCenter;
		}
		public void setExamCenter(String examCenter) {
			this.examCenter = examCenter;
		}
		public int getRollNo() {
			return rollNo;
		}
		public void setRollNo(int rollNo) {
			this.rollNo = rollNo;
		}
		public int getIsIssued() {
			return isIssued;
		}
		public void setIsIssued(int isIssued) {
			this.isIssued = isIssued;
		}
		
		
		
		
		
	}
	
	static class Result
	{
		int marks;
		String grade;
	}
}


