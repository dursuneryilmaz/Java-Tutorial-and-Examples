package AddressBook;

import java.io.*;
import AddressBook.FixedLengthStringIO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class FXML_Controller {
	final static int ID_SIZE = 4;
	final static int NAME_SIZE = 32;
	final static int STREET_SIZE = 32;
	final static int CITY_SIZE = 20;
	final static int GENDER_SIZE = 2;
	final static int ZIP_SIZE = 5;
	final static int RECORD_SIZE = (ID_SIZE + NAME_SIZE + STREET_SIZE
			+ CITY_SIZE + GENDER_SIZE + ZIP_SIZE);
	@FXML
	private Pane Pane;
	@FXML
	private TextField tf_zip;
	@FXML
	private TextField tf_street;
	@FXML
	private TextField tf_city;
	@FXML
	private TextField tf_name;
	@FXML
	private TextField tf_id;
	@FXML
	private TextField tf_gender;

	private RandomAccessFile raf;
	private RandomAccessFile raf2;
	private boolean flag = false;

	public FXML_Controller() {
		// Open or create a random access file
		try {

			raf = new RandomAccessFile("address.dat", "rw");
			raf2 = new RandomAccessFile("address1.dat", "rw");
		} catch (IOException ex) {
			System.out.print("Error: " + ex);
			System.exit(1);
		}
	}

	@FXML
	void handleBtnAddAction(ActionEvent event) {
		String id_search = tf_id.getText();
		if (!id_search.isEmpty() && id_search.length() == 4) {
			writeAddress();
		} else {
			showWarning();
		}

	}

	@FXML
	void handleBtnFirstAction(ActionEvent event) {
		try {
			if (raf.length() > 0)
				readAddress(0);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void handleBtnNextAction(ActionEvent event) {

		try {
			long currentPosition = raf.getFilePointer();
			if (currentPosition < raf.length())
				readAddress(currentPosition);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	@FXML
	void handleBtnPrevAction(ActionEvent event) {
		try {
			long currentPosition = raf.getFilePointer();
			if (currentPosition - 2 * RECORD_SIZE > 0)
				readAddress(currentPosition - 2 * 2 * RECORD_SIZE);
			else
				readAddress(0);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void handleBtnLastAction(ActionEvent event) {
		try {
			long lastPosition = raf.length();
			if (lastPosition > 0)
				readAddress(lastPosition - 2 * RECORD_SIZE);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void handleBtnUpdateAction(ActionEvent event) {

		try {
			String id_search = tf_id.getText();
			// @debug System.out.println(id_search);

			if (!id_search.isEmpty() && id_search.length() == 4) {
				if (!flag)
					raf.seek(0);
				// System.out.println(Integer.parseInt(id_search)+currentPos);
				while (raf.getFilePointer() < raf.length()) {
					String id = FixedLengthStringIO.readFixedLengthString(
							ID_SIZE, raf);
					String name = FixedLengthStringIO.readFixedLengthString(
							NAME_SIZE, raf);
					String street = FixedLengthStringIO.readFixedLengthString(
							STREET_SIZE, raf);
					String city = FixedLengthStringIO.readFixedLengthString(
							CITY_SIZE, raf);
					String gender = FixedLengthStringIO.readFixedLengthString(
							GENDER_SIZE, raf);
					String zip = FixedLengthStringIO.readFixedLengthString(
							ZIP_SIZE, raf);

					if (flag) {
						// System.out.println("Updated.");

						FixedLengthStringIO.writeFixedLengthString(
								tf_id.getText(), ID_SIZE, raf2);
						FixedLengthStringIO.writeFixedLengthString(
								tf_name.getText(), NAME_SIZE, raf2);
						FixedLengthStringIO.writeFixedLengthString(
								tf_street.getText(), STREET_SIZE, raf2);
						FixedLengthStringIO.writeFixedLengthString(
								tf_city.getText(), CITY_SIZE, raf2);
						FixedLengthStringIO.writeFixedLengthString(
								tf_gender.getText(), GENDER_SIZE, raf2);
						FixedLengthStringIO.writeFixedLengthString(
								tf_zip.getText(), ZIP_SIZE, raf2);

					}
					if (Integer.parseInt(id_search) == Integer.parseInt(id)) {
						// System.out.println(id_search+" "+id);

						tf_id.setText(id);
						tf_name.setText(name);
						tf_street.setText(street);
						tf_city.setText(city);
						tf_gender.setText(gender);
						tf_zip.setText(zip);
						flag = true;
						showInfo();
						break;
					}
					flag = false;
					// System.out.println(id);

					FixedLengthStringIO.writeFixedLengthString(id, ID_SIZE,
							raf2);
					FixedLengthStringIO.writeFixedLengthString(name, NAME_SIZE,
							raf2);
					FixedLengthStringIO.writeFixedLengthString(street,
							STREET_SIZE, raf2);
					FixedLengthStringIO.writeFixedLengthString(city, CITY_SIZE,
							raf2);
					FixedLengthStringIO.writeFixedLengthString(gender,
							GENDER_SIZE, raf2);
					FixedLengthStringIO.writeFixedLengthString(zip, ZIP_SIZE,
							raf2);

				}

			} else {
				showWarning();
			}

			if (raf.getFilePointer() == raf.length()) {
				raf.seek(0);
				raf2.seek(0);
				raf.close();
				raf2.close();
				File deleteFile = new File("address.dat");
				deleteFile.delete();
				File oldFile = new File("address1.dat");
				File newFile = new File("address.dat");

				oldFile.renameTo(newFile);
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setContentText("Ýnfo updated!\n Please restart the application");
				alert.showAndWait();
				System.exit(1);

			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void handleBtnSearchAction(ActionEvent event) throws IOException {

		try {
			raf.seek(0);
			String id_search = tf_id.getText();
			// @debug System.out.println(id_search);
			if (!id_search.isEmpty() && id_search.length() == 4) {
				while (raf.getFilePointer() < raf.length()) {
					String id_file = FixedLengthStringIO.readFixedLengthString(
							ID_SIZE, raf);
					// @debug System.out.println(id_file);
					if (id_search.equals(id_file)) {
						// @debug System.out.println("Ok");
						readAddress(raf.getFilePointer() - 2 * ID_SIZE);
						// @debug raf.seek(0);
						break;
					}
					raf.seek(raf.getFilePointer() + 91 * 2);
				}
			} else {
				showWarning();
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

	public void writeAddress() {
		try {
			raf.seek(raf.length());
			FixedLengthStringIO.writeFixedLengthString(tf_id.getText(),
					ID_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(tf_name.getText(),
					NAME_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(tf_street.getText(),
					STREET_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(tf_city.getText(),
					CITY_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(tf_gender.getText(),
					GENDER_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(tf_zip.getText(),
					ZIP_SIZE, raf);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void readAddress(long position) throws IOException {
		raf.seek(position);
		// @debug System.out.println("Ok");
		String id = FixedLengthStringIO.readFixedLengthString(ID_SIZE, raf);
		// @debug System.out.println("Ok");
		String name = FixedLengthStringIO.readFixedLengthString(NAME_SIZE, raf);
		String street = FixedLengthStringIO.readFixedLengthString(STREET_SIZE,
				raf);
		String city = FixedLengthStringIO.readFixedLengthString(CITY_SIZE, raf);
		String gender = FixedLengthStringIO.readFixedLengthString(GENDER_SIZE,
				raf);
		String zip = FixedLengthStringIO.readFixedLengthString(ZIP_SIZE, raf);

		tf_id.setText(id);
		tf_name.setText(name);
		tf_street.setText(street);
		tf_city.setText(city);
		tf_gender.setText(gender);
		tf_zip.setText(zip);
	}

	public static void showWarning() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Warning");
		alert.setContentText("Problems:\n -Enter an ID\n -Enter an ID as four-digit (like 0001)");
		alert.showAndWait();
	}

	public static void showInfo() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Info");
		alert.setContentText("Change the informations of the showing address and press update again ");
		alert.showAndWait();
	}

}
