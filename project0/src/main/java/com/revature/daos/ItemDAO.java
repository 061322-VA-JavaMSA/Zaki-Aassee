package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Item;

public interface ItemDAO {
	Item createItem (Item item);
	Item retreiveItemByNumber (String itemNumber);
	List<Item> reteiveItem ();
	Item retreiveItemByItemPrice(String itemName);
	Item retreiveItemByItemQuantity(int itemQuantity);
	Item deleteItemByNumber(Item itemNumber);

	
	
	
	

}
