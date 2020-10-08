package encapsulation;

/*
 * encapsulation achieves restrictions in read/write operations or manage read/write operations rules 
 * encapsulated fields access modifiers changes from public to private generally
 * accessing attributes made by public getter/setter methods, thanks to these a attribute can be made read/write only
 * this keywords mean is following variable is belong to this class. it used to separate variables which has same names
 * 
 * */
public class Product {
	private int id;
	private String name;
	private String description;
	private float price;
	private int stockAmount;
	private String productCode;

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
