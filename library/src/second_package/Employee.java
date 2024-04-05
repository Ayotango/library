package second_package;

import third_package.Item;

public interface Employee {

	  void leaseItem(String clientID, String itemID);
	  void returnItem(String itemID);
	  void showLeasedItems(String clientID);
	  void showAllItems();
}
