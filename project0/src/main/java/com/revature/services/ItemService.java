package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.ItemDAO;
import com.revature.daos.ItemPostgres;
import com.revature.models.Employee;
import com.revature.models.Item;

public class ItemService {
	private Logger log = LogManager.getLogger(ItemService.class);
	
	ItemDAO iD = new ItemPostgres();
	
	public List<Item> getItems(){
		return iD.reteiveItem();
		
	}
	
	public Item createItem (Item i) {
		
		 
		Item item = iD.createItem(i);
		log.info("item: " + item + "was added to the store ");
		return item;
		
		
	}
	
	
	
	public Item deleteItem (Item itemNumber) {
		
		return iD.deleteItemByNumber(itemNumber);

		
	}

	public Item getItem(String itemNumber) {
		return iD.retreiveItemByNumber(itemNumber);
		
	}
public Item getPrice (String itemprice ) {
	return iD.retreiveItemByItemPrice(itemprice);
	
}
}
	

