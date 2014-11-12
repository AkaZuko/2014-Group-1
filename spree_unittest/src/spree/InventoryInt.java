package spree;

public interface InventoryInt {

	void getStatus();
	int pushItem();
	int popItem();
	
	void viewInventory();
	
	//returns -1 for illegal no. of items ,and returns no of items after operation otherwise
}
