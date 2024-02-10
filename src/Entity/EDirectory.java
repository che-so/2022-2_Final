package Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import ValueObject.VDirectory;

public class EDirectory {

	public Vector<VDirectory> getDirectories(String fileName) { // 파일 이름 받아오기
		Vector<VDirectory> vDirectories = new Vector<VDirectory>(); // 벡터 선언
		try {
			Scanner scanner = new Scanner(new File("directory/" + fileName));
			while (scanner.hasNext()) {
				VDirectory vDirectory = new VDirectory();
				vDirectory.read(scanner);
				vDirectories.add(vDirectory);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vDirectories;
	}

}
