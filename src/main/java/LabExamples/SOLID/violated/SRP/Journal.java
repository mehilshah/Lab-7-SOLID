package LabExamples.SOLID.violated.SRP;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Journal {
	private final List<String> entries = new ArrayList<>();

	private static int count = 0;

	public void addEntry(String text) {
		entries.add("" + (++count) + ": " + text);
	}

	public void removeEntry(int index) {
		entries.remove(index);
	}

	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}

	public void save(String filename) throws Exception {
		File file = new File(filename);

		if (!file.exists()) {
			file.createNewFile();
		}

		try (PrintStream out = new PrintStream(file)) {
			out.println(entries.toString());
		}
	}

	public void load(String filename) {
	}

	public void load(URL url) {
	}
}
