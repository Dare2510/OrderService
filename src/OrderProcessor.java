public abstract class OrderProcessor {

	final void processOrder(Order order){
		order.discount(order);
		deliveryNeeded();
		orderCompleted();
	}
	abstract void orderCompleted();

	boolean deliveryNeeded(){
		System.out.println("Delivery not required");
		return false;
	}
}

final class DeliveryOrder extends OrderProcessor{

	@Override
	void orderCompleted() {
		System.out.println("The Delivery will be as soon as possible delivered");
	}

	@Override
	boolean deliveryNeeded(){
		System.out.println("Delivery required");
		return true;
	}

}

final class PickupOrder extends OrderProcessor{

	@Override
	void orderCompleted() {
		System.out.println("Your order is waiting for you to pickup at one of our stores");

	}
}
