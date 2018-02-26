

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class MovieReviews 
{

	public static void main(String[] args) 
	{
		double average, sum = 0.0;
		//ArrayList will not allow primatives, must be class
									 // new is calling a default constructor 
		ArrayList<Double> reviewsList = new ArrayList<Double>();
		
		DecimalFormat oneDec = new DecimalFormat("#.0");
		
		try 
		{
			Scanner fileScanner = new Scanner(new File("MovieReviews2016.txt"));
			
			while(fileScanner.hasNextDouble())
			{
				//define variable to read
				double review = fileScanner.nextDouble();
				sum+=review;
				reviewsList.add(review);	//.add will add review to reviewList ArrayList
				
			}
			fileScanner.close();
			average = sum/reviewsList.size();	//size() method gets the length of the ArrayList
			
			//1) print the number of reviews
			//2) print the average to 1 decimal place
			System.out.println("The number of reviews is: " + reviewsList.size() + "\n" +
							   "The average movie review is: "+ oneDec.format(average));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println();
		}
		
		

	}

}
