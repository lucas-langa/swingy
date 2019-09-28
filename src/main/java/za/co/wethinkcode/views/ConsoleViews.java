package za.co.wethinkcode.views;

public class ConsoleViews{
	private String greetings;
	private String PlayerName;
	public static void main(String args[]){
		encounterText();
	}
	public ConsoleViews(String name){
		PlayerName = name;
	}

	public static void welcomeText( ){
		System.out.print("/*********************************************************/\n"+
							"/*        Welcome to a text based semi violent RPG       */\n"+
							"/*        To Start:                                      */\n"+
							"/*        1.Select an existing hero                      */\n"+
							"/*	  2.Create a New Hero                            */\n"+
							"/*********************************************************/\n");
	}
	
	public static void encounterText(){
		System.out.printf("You've encountered an enemy\nWhat do you want to do?\n1.Fight\n2.Run Away\n");
	}
}