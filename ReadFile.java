
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		Dictionary tree = new Dictionary();
		
		Scanner input = new Scanner(System.in);
		int option = -1;
		boolean dataOK = true;
		try {
			do {
				System.out.println("Enter 1 to clear dictionary, " + "2 to add text from keyboard , "
						+ "3 to add text from a file," + "4 to search for a word count, "
						+ "5 to display number of nodes, 6 to quit ");
				System.out.println("Please enter menu option :");

				while (!input.hasNextInt()) {
					System.out.println("Invalid Account number. Please enter only digits:");
					input.next();
				}
				option = input.nextInt();
				switch (option) {
				case 1:
					tree.makeEmpty();
					System.out.println("Dictionary has been cleared.");
					break;
				case 2:
					System.out.println("please input the word :");
					input.nextLine();
					String newWord = input.nextLine().toLowerCase().replaceAll("[^0-9a-zA-Z]", "");
					tree.insert(newWord);
					System.out.println(newWord + " has been added into dictionary");
					break;
				case 3:
					System.out.println("please enter the file name:");
					input.nextLine();
					String text = input.nextLine();
					// "/Users/xuanli/Desktop/Oliver.txt"
					File file = new File(text);
					if (!file.exists()) {
						System.out.println("invalid file ,please check the file name and do it again");
					} else {
						tree.writeDictionary(file);
						System.out.println("file enter into dictionary");
					}
					break;
				case 4:
					System.out.println("Enter the word to search for :");
					input.nextLine();
					String findWord = null;
					findWord = input.nextLine().replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
					int i = tree.search(findWord);
					System.out.println(findWord + " occurs " + i + " times");
					break;
				case 5:
					String node = "";
					if (tree.count() == 0 || tree.count() == 1) {
						node = "node";
					} else {
						node = "nodes";
					}
					System.out.println("There are " + tree.count() + " " + node);
					break;
				case 6:
					System.out.println("Thanks for USING");
					System.out.println("program ending...");
					break;
				default:
					System.out.println("Invalid menu option");
				}
			} while (option != 6);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}
}

