package nestedclass;

public class NestedClassesTest2 {

	public static void main(String[] args) {
		Exam e1 = new Exam("MCQ", "CN", 100);
		e1.attempExam(e1.getExamName());
		
		Exam e2 = new Exam("MCQ", "DBMS", 100);
		e2.attempExam(e2.getExamName());
		
		Exam e3 = new Exam("MCQ", "OS", 200);
		e3.attempExam(e3.getExamName());
	
		System.out.println("=======================");
			
		Exam.Result r1 = new Exam.Result(90, "A", e1.getExamName());
		System.out.println("****Subject**** "+r1.getSubject());
		System.out.println(" Marks: "+r1.getMarks());
		System.out.println(" Grade: "+r1.getGrade());
		
		
		Exam.Result r2 = new Exam.Result(80, "B", e2.getExamName());
		System.out.println("****Subject**** "+r2.getSubject());
		System.out.println(" Marks: "+r2.getMarks());
		System.out.println(" Grade: "+r2.getGrade());
		
		
		Exam.Result r3 = new Exam.Result(70, "B+", e3.getExamName());
		System.out.println("****Subject**** "+r3.getSubject());
		System.out.println(" Marks: "+r3.getMarks());
		System.out.println(" Grade: "+r3.getGrade());
		
		

	}
}


class Exam
{
	String type; //MCQ, Theorotical, both
	String examName;
	int noOfStudentsAppearing;
	int marks;
	
	String subjects[] = {"CN", "DBMS", "OS"};
	
	private HallTicket ht = new HallTicket(subjects,  "Mansi", "pune" ,101 , 1);
	
	public Exam(String type, String examName, int noOfStudentsAppearing) {
		super();
		this.type = type;
		this.examName = examName;
		this.noOfStudentsAppearing = noOfStudentsAppearing;
		
	}
	
	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	void attempExam(String s) 
	{
		//System.out.println("attempting the exam.....");
		if(ht.getIsIssued() == 1)
		{
			
			System.out.println("Yon can appear for the exam "+s);
		}
		else
		{
			try
			{
				throw new HallTicketNotIssuedYetException("Please collect the hall ticket first");
			}
			catch(HallTicketNotIssuedYetException he)
			{
				System.out.println(he);
			}
		}
	}

	
	
	class HallTicket
	{
		String[] subjectName;
		String studentName;
		String examCenter;
		int rollNo;
		int isIssued;
		
		public HallTicket(String[] subjectName, String studentName, String examCenter, int rollNo, int isIssued) {
			super();
			this.subjectName = subjectName;
			this.studentName = studentName;
			this.examCenter = examCenter;
			this.rollNo = rollNo;
			this.isIssued = isIssued;
		}
		
		
		public String[] getSubjectName() {
			return subjectName;
		}

		public void setSubjectName(String[] subjectName) {
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
		String subject;
		public Result(int marks, String grade, String subject) {
			super();
			this.marks = marks;
			this.grade = grade;
			this.subject = subject;
		}

		public int getMarks() {
			return marks;
		}

		public void setMarks(int marks) {
			this.marks = marks;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}
		
		
		
	}
}
