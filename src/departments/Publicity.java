package departments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

public class Publicity extends Department {

	public Publicity() throws IOException {
		super();

	}

	public String[] getDetails() throws IOException {

		File pub = new File("res/Publicity");
		String details[] = new String[10];

		int i = 0;

		BufferedReader br = new BufferedReader(new FileReader(pub));
		String line;
		while ((line = br.readLine()) != null) {

			details[i] = line;
			i++;

		}

		return details;

	}

}
