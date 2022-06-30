package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Item;
import com.revature.util.ConnectionHandler;

public class ItemPostgres implements ItemDAO {

	@Override
	public Item createItem(Item item) {
		String sql = "insert into items (item_number, item_name, item_price, item_category, item_model, item_quantity) values (?,?,?,?,?,?) returning item_number;";
		try (Connection c = ConnectionHandler.getConnectionFromEnv();) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, item.getItemNumber());
			ps.setString(2, item.getItemName());
			ps.setFloat(3, item.getItemPrice());
			ps.setString(4, item.getItemCategory());
			ps.setString(5, item.getItemModel());
			ps.setInt(6, item.getItemQuantity());

			ResultSet rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Item retreiveItemByNumber(String itemNumber) {
		Item item = new Item();

		String sql = "select * from items where item_number = ?;";
		try (Connection c = ConnectionHandler.getConnectionFromEnv();) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, itemNumber);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				item.setItemNumber(rs.getString("item_number"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Item> reteiveItem() {

		String sql = "select * from items;";
		List<Item> items = new ArrayList<>();
		try (Connection c = ConnectionHandler.getConnectionFromEnv();) {
			PreparedStatement ps = c.prepareStatement(sql);

			// Statement s = c.createStatement();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Item item = new Item();
				item.setItemNumber(rs.getString("item_number"));
				item.setItemName(rs.getString("item_name"));
				item.setItemPrice(rs.getFloat("item_price"));
				item.setItemCategory(rs.getString("item_category"));
				item.setItemModel(rs.getString("item_model"));
				item.setItemQuantity(rs.getInt("item_quantity"));

				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return items;
	}

	@Override
	public Item retreiveItemByItemPrice(String itemprice) {
		Item item = new Item();
		String sql = "select item_price from items where item_number=?;";

		try (Connection c = ConnectionHandler.getConnectionFromEnv();) {

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, itemprice);
			ResultSet rs = ps.executeQuery();
			rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public Item retreiveItemByItemQuantity(int itemQuantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item deleteItemByNumber(Item itemNumber) {
		String sql = "delete from items where item_number = ? returning item_number;";
		try (Connection c = ConnectionHandler.getConnectionFromEnv();) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, itemNumber.getItemNumber());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				itemNumber.setItemNumber(rs.getString("item_number"));
			}

		}

		catch (SQLException e) {

			e.printStackTrace();

		}
		return itemNumber;
	}

}
