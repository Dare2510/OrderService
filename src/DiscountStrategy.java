abstract class DiscountStrategy{

	private final Order order;
	private double finalPrice;

	abstract double totalPrice(Order order);

	public double getFinalPrice() {
		return finalPrice;
	}

	public DiscountStrategy(Order order) {
		this.order = order;
	}
}

final class PercentageDiscount extends DiscountStrategy{

	public PercentageDiscount(Order order) {
		super(order);
	}

	@Override
	double totalPrice(Order order) {
		double finalPrice = 0;
		if(order.getTotal()>500 && order.getTotal()<999){
			finalPrice = super.getFinalPrice()+order.getTotal()*0.9;
		} else if (order.getTotal()>1000) {
			finalPrice = super.getFinalPrice()+order.getTotal()*0.8;;

		} return finalPrice;
	}
}


final class NoDiscount extends DiscountStrategy{

	public NoDiscount(Order order) {
		super(order);
	}

	@Override
	double totalPrice(Order order) {
		return order.getTotal();
	}
}