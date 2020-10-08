package constructors;

/*
 * constructors used when getting an instance from a class. 
 * constructor can be used when a product get a new feature 
 * 
 * 
 * */
public class Product {
	private int id;
	private String name;
	private String description;
	private float price;
	private int stockAmount;
	private String productCode;
	
	// Default Constructor
	// if there is no other constructor then no need to write default constructor otherwise it shoult be written
	public Product() {
		System.out.println("default constructor worked!");
	}
	
	// Custom constructor
	// when default constructor and custom constructor exist in same class method overloading occurs automatically
	// method overloading is situation of existence of two method with same name but different parameters
	public Product(int id) {
		this.id = id;
		System.out.println("custom constructor worked!");
	}

	// public getter/setters can be used by anywhere
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	// stockAmount can be access from same package only
	int getStockAmount() {
		return stockAmount;
	}

	// make and apply a rule(business logic) when assigning a value to stockAmount
	// attribute
	void setStockAmount(int stockAmount) {
		if (stockAmount >= 10) {
			this.stockAmount = stockAmount;
		} else {
			System.out.println("Stock amount must be at least 10!");
			// stop the program in an inappropriate situation
			System.exit(stockAmount);
		}
	}

	// productCode is private and has no setter function so it is a readonly field
	// productCode generated by product itself
	public String getProductCode() {
		return this.name.substring(0, 1) + 1000 + this.id;
	}

}