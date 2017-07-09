
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Dictionary {
	private TreeMap<String, Integer> tm;
	Set<Map.Entry<String, Integer>> entrySet;

	public Dictionary() {
		tm = new TreeMap<String, Integer>();
		entrySet = tm.entrySet();
	}

	public void makeEmpty() {
		tm.clear();
	}

	public void writeDictionary(File file) throws FileNotFoundException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String inputLine = null;
			while ((inputLine = br.readLine()) != null) {

				String[] words = inputLine.split("[ \n\t\r.,;:!?(){}]");
				for (int wordCounter = 0; wordCounter < words.length; wordCounter++) {
					String key = words[wordCounter].toLowerCase().replaceAll("^\\W", "").replace("--", "").replace("-",
							"");

					if (key.length() > 0) {
						if (tm.get(key) == null) {
							tm.put(key, 1);
						} else {
							int value = tm.get(key).intValue();
							value++;
							tm.put(key, value);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("");
		} catch (IOException e) {
			System.out.println("");
		}
	}

	public void insert(String newWord) {
		newWord = newWord.replaceAll("^\\s", "").toLowerCase();
		if (tm.containsKey(newWord)) {
			tm.replace(newWord, new Integer(tm.get(newWord).intValue() + 1));
		} else
			tm.put(newWord, 1);
	}

	public int search(String string) {
		string = string.replaceAll("^\\s", "").toLowerCase().replace("--", "");
		if (tm == null) {
			System.out.println("Nothing in dictionary");
			return 0;
		} else if (tm.containsKey(string)) {
			return tm.get(string).intValue();
		} else
			return 0;
	}

	public int count() {
		int treeSize = tm.size();
		return treeSize;
	}

}
