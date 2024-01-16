package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dto.Product;
import helper.HelperClassProduct;

public class ProductCrud {
	HelperClassProduct helperClassProduct = new HelperClassProduct();
	Connection connection = helperClassProduct.helperMethod();

	public void saveProduct(Product product) {

		String quary = "Insert into product values(?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(quary);
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getBrand());
			preparedStatement.setString(4, product.getType());
			preparedStatement.setDouble(5, product.getCost());

			preparedStatement.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void getAllProduct() {
		String query = "select * from product";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(query);

			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
				System.out.println(resultSet.getString(5));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void getProductById(int id) {
		String query = "select * from product where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
				System.out.println(resultSet.getString(5));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void deleteProductById(int id) {
		String query = "delete from product where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public void update(Product product) {
		String query = "update  product set name=?,brand=?,type=?,cost=? where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getBrand());
			preparedStatement.setString(3, product.getType());
			preparedStatement.setDouble(4, product.getCost());
			preparedStatement.setInt(5, product.getId());

			preparedStatement.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void batchOfProduct(List<Product> list) {
		String query = "insert into product values(?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			for (Product product : list) {
				preparedStatement.setInt(1, product.getId());
				preparedStatement.setString(2, product.getName());
				preparedStatement.setString(3, product.getBrand());
				preparedStatement.setString(4, product.getType());
				preparedStatement.setDouble(5, product.getCost());

				preparedStatement.addBatch();

			}
			preparedStatement.executeBatch();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
