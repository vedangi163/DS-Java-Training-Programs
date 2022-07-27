
public class FundTransferTest {
	public static void main(String[] args) {

		Cricketer cricketer1 = new Cricketer();
//		cricketer1.bat();
		
		Batting b = new Batsman();
//		b.eat();
//		b.act();
//		b.proact();
		b.bat();
		b.hitSixer();
		b.hitFourRuns();
		
		
		Bowler bb = new Bowler();
		bb.bowl();
		bb.howIsThat();
		
	}
}






//The height of your success
//cannnot exceed the height of your
//personal development 1-100 - 60 

class A
{
}

class B 
{
}

// class  extends class
class C extends A
{
}
interface P { }
interface Q { }

interface R extends P,Q
{
	
}

class Z extends C implements R
{
	
}





class Person1
{
	String name;
}
abstract class Player extends Person1
{
	abstract void play();
}

class Cricketer extends Player
{
	void playCricket() {
		System.out.println("Playing cricket....");
	}
	void play() {
		System.out.println("Enjoying cricket.....");
	}
}

interface Batting
{
	void bat();
	int hitSixer();
	int hitFourRuns();
}
interface Bowling
{
	void bowl();
}
interface WicketKeeping
{
	void keepWicket();
}

class Team
{
	
}
class CricketTeam extends Team
{
	Cricketer cricketer1 = new Cricketer();
	Cricketer cricketer2 = new Cricketer();
	Cricketer cricketer3 = new Cricketer();
	Cricketer cricketer4 = new Cricketer();
	Cricketer cricketer5 = new Cricketer();
	Cricketer cricketer6 = new Cricketer();
	Cricketer cricketer7 = new Cricketer();
	Cricketer cricketer8 = new Cricketer();
	Cricketer cricketer9 = new Cricketer();
	Cricketer cricketer10 = new Cricketer();
	Cricketer cricketer11 = new Cricketer();
	
	
}

class Stadium
{
	
}

class CricketStadium
{
	CricketTeam teamIndia = new CricketTeam();
	CricketTeam teamAus =  new CricketTeam();
	
}

class Bat
{
	
}

class Batsman extends Cricketer implements Batting
{
	Bat b = new Bat(); //hasA
	
	public void bat() {
		System.out.println("The batsman is batting....");
	}
	
	public int hitSixer() {
		System.out.println("hitting sixer....");
		return 6;
	}
	
	public int hitFourRuns() {
		System.out.println("hitting...four runs...");
		return 4;
	}
	
}

class WicketKeeper extends Cricketer implements WicketKeeping
{
	public void keepWicket() {
		System.out.println("Wicket keeper is keeping the wicket...");
	}
	public void stumpOut() {
		System.out.println("Stump out....");
	}
}
class Bowler extends Cricketer implements Bowling
{
	public void bowl() {
		System.out.println("Bowler is bowling...");
	}
	public void throwYorker() {
		System.out.println("throwing yorker....");
	}
	boolean howIsThat() {
		System.out.println("how is that??????");
		return true;
	}
}
interface Spinning
{
	void spin();
}

class Spinner extends Bowler implements Spinning
{
	public void spin() {
		System.out.println("Spinner is spinning....");
	}
}





