package za.co.wethinkcode.views;

public class ConsoleViews{
	private String greetings;
	private String PlayerName;

	public ConsoleViews(String name){
		PlayerName = name;
	}

	public void topText( ){
		System.out.printf("/***********************************************************/\n",
							"/*        Welcome to a text based semi violent RPG        */\n",
							"/*		  To Start:										   */\n",
							"/*		  1.Select an existing hero						   */\n",
							"/*		  2.Create a New Hero							   */\n",
							"/**********************************************************/ ");
	}
	 
}