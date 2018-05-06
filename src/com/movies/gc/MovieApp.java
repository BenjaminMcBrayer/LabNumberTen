//Benjamin McBrayer, 5.6.2018
//This Java console program lists movies by category.

package com.movies.gc;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;

public class MovieApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		ArrayList<Integer> categoryNums = new ArrayList<>(5);
		ArrayList<String> categories = new ArrayList<>(5);
		ArrayList<Movie> movies = new ArrayList<>(10);
		Movie a = new Movie("Doctor Strange", "Action & Adventure");
		Movie b = new Movie("Den of Thieves", "Action & Adventure");
		Movie c = new Movie("Big Lebowski", "Comedy");
		Movie d = new Movie("Game Night", "Comedy");
		Movie e = new Movie("13th", "Documentary");
		Movie f = new Movie("What Happened, Miss Simone?", "Documentary");
		Movie g = new Movie("Wind River", "Drama");
		Movie h = new Movie("Cinema Paradiso", "Drama");
		Movie i = new Movie("Blade Runner", "Sci-Fi & Fantasy");
		Movie j = new Movie("Cloud Atlas", "Sci-Fi & Fantasy");
		Collection<String> selections = new TreeSet<String>(Collator.getInstance());
		String category = null;
		String playAgain = "";
		double userNum;

		// Populate ArrayLists with numbers, categories, and movies.
		categoryNums.add(1);
		categoryNums.add(2);
		categoryNums.add(3);
		categoryNums.add(4);
		categoryNums.add(5);
		categories.add("Action & Adventure");
		categories.add("Comedy");
		categories.add("Documentary");
		categories.add("Drama");
		categories.add("Sci-Fi & Fantasy");
		movies.add(a);
		movies.add(b);
		movies.add(c);
		movies.add(d);
		movies.add(e);
		movies.add(f);
		movies.add(g);
		movies.add(h);
		movies.add(i);
		movies.add(j);

		System.out.println("Welcome to the Grand Circus Movie List Application!");

		System.out.println(i.getCategory());

		do {
			// Display categories.
			displayCategories(categoryNums, categories);

			// Ask the user to choose a category.
			userNum = Validator.getDouble(scnr,
					"\nThere are 10 movies in this list.\nPlease enter the number of the category in which you are interested (1 - 5). ",
					1, 5);

			// Match the number to a distinct category name.
			category = pickCategory(categories, category, userNum);

			// Read through all movies; add to a TreeSet those whose category matches the
			// one entered by the user. (TreeSet automatically alphabetizes the list of
			// elements.)
			addMovies(movies, selections, category);

			// Display a line for each movie.
			printMovies(selections);

			// Clear selections in case the user wants to enter another category number.
			selections.clear();

			// Prompt user to continue.
			playAgain = playAgain(scnr);

		} while (playAgain.equalsIgnoreCase("y"));

		System.out.println("Goodbye!");

		scnr.close();

	}

	// Methods.
	public static String playAgain(Scanner scnr) {
		String playAgain;
		System.out.print("Continue (y/n)? ");
		playAgain = scnr.next();
		System.out.println();
		return playAgain;
	}

	public static void printMovies(Collection<String> selections) {
		for (String selection : selections) {
			System.out.println(selection);
		}
	}

	public static void addMovies(ArrayList<Movie> movies, Collection<String> selections, String category) {
		for (Movie m : movies) {
			String cat = m.getCategory();
			if (cat == category) {
				selections.add(m.getMovie());
			}
		}
	}

	public static String pickCategory(ArrayList<String> categories, String category, double userNum) {
		if (userNum == 1) {
			category = categories.get(0);

		} else if (userNum == 2) {
			category = categories.get(1);

		} else if (userNum == 3) {
			category = categories.get(2);

		} else if (userNum == 4) {
			category = categories.get(3);

		} else if (userNum == 5) {
			category = categories.get(4);
		}
		return category;
	}

	public static void displayCategories(ArrayList<Integer> categoryNums, ArrayList<String> categories) {
		System.out.printf("%1$-15s %2$-8s", "Number", "Category");
		System.out.printf("\n%1$-15s %2$-8s", "=======", "=======");

		for (int i = 0; i < categoryNums.size(); ++i) {
			System.out.printf("\n%1$-15s %2$-8s", categoryNums.get(i), categories.get(i));
		}
	}

}
