public class FoodTruck {

	private int id;
	private String name;
	private String address;
	private String foodType;
	
	// constructors
	public FoodTruck(String name, String address, String foodType) {
		super();
		this.name = name;
		this.address = address;
		this.foodType = foodType;
	}

	public FoodTruck(int id, String name, String address, String foodType) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.foodType = foodType;
	}

	// getters and setters
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	// toString to debug or log info
	@Override
	public String toString() {
		return "FoodTruck [id=" + id + ", name=" + name + ", address=" + address + ", foodType=" + foodType + "]";
	}
	
}
