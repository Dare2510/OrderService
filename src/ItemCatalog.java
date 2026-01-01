import java.util.ArrayList;
import java.util.List;

public final class ItemCatalog {

	private final List<Item> itemCatalog = new ArrayList<>();

	public ItemCatalog() {}

	public List<Item> getItemCatalog() {
		return itemCatalog;
	}

	public void outputItemCatalog(){
		for(Item item : itemCatalog){
			System.out.println(item.toString());
		}
	}

	public  void addItem(Item item){
		itemCatalog.add(item);
	}
	//Stock Item creation with Input Validation
	public static ItemCatalog createStockItems() {
		ItemCatalog stockItems = new ItemCatalog();
		System.out.println("Now we create a Catalog");

		int catalogSize;

		while (true) {
			String input = InputReader.readString("How many Products do you want to add?");
			try {
				catalogSize = Integer.parseInt(input);
				if (catalogSize <= 0) {
					System.out.println("Please enter a number greater than 0.");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.");
			}
		}


		while (catalogSize > 0) {

			String productName = InputReader.readString("Please type in a Product name");

			double price;
			while (true) {
				String priceInput = InputReader.readString("Please type in a price for your Product");
				try {
					price = Double.parseDouble(priceInput);
					if (price <= 0) {
						System.out.println("Price must be greater than 0.");
						continue;
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid price. Please enter a number.");
				}
			}

			int stock;
			while (true) {
				String stockInput = InputReader.readString("Please type in how many are on stock");
				try {
					stock = Integer.parseInt(stockInput);
					if (stock < 0) {
						System.out.println("Stock cannot be negative.");
						continue;
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid stock. Please enter a number.");
				}
			}

			try {
				stockItems.addItem(new Item(productName, price, stock));
				catalogSize--;
			} catch (InputExceptions e) {
				System.out.println("Error creating item: " + e.getMessage());
				System.out.println("Please re-enter the product.");
			}
		}

		return stockItems;
	}


	public static class Item {
		final String productName;
		final double price;
		int stock;

		//Item creation with validation

		public Item(String productName, double price, int stock) throws InputExceptions {
				if (productName.length() < 2) {
					throw new InputExceptions("Product name is too short - try again");
				}
				if (price < 0) {
					throw new InputExceptions("Price must be > 0 - try again");
				}
				if (stock < 0) {
					throw new InputExceptions("Stock must be > 0 - try again");

				}

				this.productName = productName;
				this.price = price;
				this.stock = stock;

		}

		@Override
		public String toString() {
			return "Item: " + productName +
					"\nPrice: " + price +
					"\nStock: " + stock;
		}

		@Override
		public boolean equals(Object o) {
			if (o == null || getClass() != o.getClass()) return false;
			Item item = (Item) o;
			return Double.compare(price, item.price) == 0 && stock == item.stock
					&& productName.equals(item.productName);
		}

		@Override
		public int hashCode() {
			int result = productName.hashCode();
			result = 31 * result + Double.hashCode(price);
			result = 31 * result + stock;
			return result;
		}
	}
}


