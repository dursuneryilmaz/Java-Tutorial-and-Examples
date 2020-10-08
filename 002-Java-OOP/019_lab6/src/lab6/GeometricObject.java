package lab6;

public class GeometricObject {
	private boolean filled = false;
	private String color = "white";
	private java.util.Date dateCreated;

	public GeometricObject() {
		dateCreated = new java.util.Date();
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(java.util.Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}
