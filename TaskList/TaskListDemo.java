package edu.orangecoastcollege.ereynoso7.IC25;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskListDemo 
{

	public static void main(String[] args) 
	{
		Scanner consoleScanner = new Scanner(System.in);
		String name, date, deadline;
		int priority;
		
		//declare ArrayList<>
		ArrayList<TaskList> finalsWeekList = new ArrayList<TaskList>();
		
		File binaryFile = new File("TaskList.bin");
		
		if(binaryFile.exists())
		{
			//We have data to read
			//Binary file -> Array -> ArrayList
			try {
				//Step 1) Create the reference to the binary file:
				ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
				//Step 2) Read all the TaskList into an Array:
				TaskList[] finalsWeek = (TaskList[])fileReader.readObject();	//typecast fileReader into Dog[]
				fileReader.close();
				//Step 3) Add all the TaskList from the Array into the ArrayList
				//Loop through the array one single dog at a time
				//use a for each loop
				for(TaskList singleTask:finalsWeek)  //singleDog is like i; we create this variable just for the loop
				{
					//Add the single dog to the ArrayList
					finalsWeekList.add(singleTask);
					//Print the single dog to the console
					System.out.println(singleTask);
				}
			} 
			
			catch (IOException e) 
			{
				System.out.println("File not found.");;
			}
			
			catch(ClassNotFoundException e)
			{
				System.out.println("File found, but data was in wrong format.");
			}
		}
		else
		{
			System.out.println("[None, please enter new task]");
		}
		
		do{
			System.out.println("Please enter task name (or \"quit\" to exit): ");
			name = consoleScanner.nextLine();
			
			if(!name.equalsIgnoreCase("quit"))
			{
			System.out.println("Please enter due date (in form MM/DD/YYYY): ");
			date = consoleScanner.nextLine();
			
			System.out.println("Please enter deadline: ");
			deadline = consoleScanner.nextLine();
			
			System.out.println("Please enter priority: ");
			priority = consoleScanner.nextInt();
			
			consoleScanner.nextLine();
			
			//Step 1) Create a new Dog object
			TaskList finalsWeekUpdate = new TaskList(name, date, deadline, priority);
			
			//Step 2) Add the bread new Dog to the ArrayList
			finalsWeekList.add(finalsWeekUpdate);
			}

		}while(!name.equalsIgnoreCase("quit"));

		try{
			// All dogs have been entered, write to the binary file
			ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));	//uses the reference file binaryFile to access "dogs.dat"
			//Convert ArrayList<> to an array[] then write it to a binary file
			fileWriter.writeObject(finalsWeekList.toArray(new TaskList[finalsWeekList.size()])); //arrayList to array to binary file
			//for playlist to get the length you use keyword   size
			//doesnt require loop; transfers all playlist info to array
			
			fileWriter.close();
			consoleScanner.close();
			}
			
			catch(IOException e)
			{
				System.out.println("File not found.");
			}
	}

}
