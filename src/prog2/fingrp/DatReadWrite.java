package prog2.fingrp;
import java.io.*;
import java.nio.file.FileVisitResult;
import java.util.ArrayList;

public class DatReadWrite<T> {
	T obj;

	DatReadWrite() {
		//empty constructor only for accessing methods
	}

	DatReadWrite(T obj) {
		this.obj = obj; //can only be used by the write method
	}

	/**
	 * <p>Used to read a .DAT file and returns a ArrayList of courses (semester). Because it returns an ArrayList, you can
	 * 	 use the methods provided by the ArrayList class to the {@code DatReadWrite.read()} method. For readability's sake,
	 * 	 it is sugggested to name a variable similar to the one shown below.
	 * </p>
	 *
	 * <br>
	 * 	{@code  DatReadWrite<Course> readCourseDat = new DatReadWrite<>();}
	 * 	{@code  ArrayList<Course> semester = readCourseDat.read("FILE_PATH");}
	 * <br>
	 *
	 */
	public ArrayList<T> read(String fileIn) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileIn));

		ArrayList<T> list = (ArrayList<T>) ois.readObject();
		ois.close();

		return list;
	}

	/**
	 * <p>Used to read a .DAT file and returns a ArrayList of courses (semester). Because it returns an ArrayList, you can
	 * 	 use the methods provided by the ArrayList class to the {@code DatReadWrite.read()} method. For readability's sake,
	 * 	 it is sugggested to name a variable similar to the one shown below.
	 * </p>
	 *
	 * <br>
	 * 	{@code  DatReadWrite<Course> readCourseDat = new DatReadWrite<>();}
	 * 	{@code  ArrayList<Course> semester = readCourseDat.read("FILE_PATH");}
	 * <br>
	 */
	public ArrayList<T> read(File fileIn) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileIn));

		ArrayList<T> list = (ArrayList<T>) ois.readObject();
		ois.close();

		return list;
	}





	public void write(String fileOut) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileOut));

		oos.writeObject(obj);
		oos.close();
	}

	/**
	 * <p>Used to write an ArrayList to a new .DAT file. </p>
	 *
	 * <p>Input the ArrayList of Courses (semester) and the destination on
	 * 	where the .dat file will go.</p>
	 *  <br>
	 * Example:
	 * <pre>
	 *     {@code DatReadWrite<Course> courseToDat = new DatReadWrite<>();}
	 *     {@code DatReadWrite.write([ArrayList<Course> var, FILE_PATH]);}
	 * </pre>
	 * */

	public void write(File fileOut) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileOut));

		oos.writeObject(obj);
		oos.close();
	}

	/**
	 * <p>Used to write an ArrayList to a new .DAT file. </p>
	 *
	 * <p>Input the ArrayList of Courses (semester) and the destination on
	 * 	where the .dat file will go.</p>
	 *  <br>
	 * Example:
	 * <pre>
	 *     {@code DatReadWrite<Course> courseToDat = new DatReadWrite<>();}
	 *     {@code courseToDat.write([ArrayList<Course> var, FILE_PATH]);}
	 * </pre>
	 * */

	public void write(ArrayList<T> input, String fileOut) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileOut));

		oos.writeObject(input);
		oos.close();
	}

	/**
	 * <p>Used to write an ArrayList to a new .DAT file. </p>
	 *
	 * <p>Input the ArrayList of Courses (semester) and the destination on
	 * 	where the .dat file will go.</p>
	 *  <br>
	 * Example:
	 * <pre>
	 *     {@code DatReadWrite<Course> courseToDat = new DatReadWrite<>();}
	 *     {@code courseToDat.write([ArrayList<Course> var, FILE_PATH]);}
	 * </pre>
	 * */

	public void write(ArrayList<T> input, File fileOut) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileOut));

		oos.writeObject(input);
		oos.close();
	}

}
