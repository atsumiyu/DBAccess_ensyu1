package DBAccess_Ensyu01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private Connection connection;

    public ProductDao(Connection connection) {
        this.connection = connection;
    }

    public ProductRecord findById(int id) {

        final var SQL = "SELECT * FROM products WHERE id = " + id;

        ProductRecord obj = null;

        try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();

            // ProductRecordにDBからとってきたカラムをレコード化させる。
            while (rs.next()) {
                obj = new ProductRecord(rs.getInt("id"),rs.getString("name"), rs.getInt("price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return obj;
    }

    public List<ProductRecord> findByName(String name) {

        final var SQL = " SELECT * FROM products WHERE name LIKE '%" + name + "%' ";

        var list = new ArrayList<ProductRecord>();

        try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                var user = new ProductRecord(rs.getInt("id"),rs.getString("name"), rs.getInt("price"));
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;

    }

    public int insert(ProductRecord insertdata) {

        final var SQL = "INSERT INTO products VALUES (?,?,?)";

        int num;

        try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            stmt.setInt(1,insertdata.id());
            stmt.setString(2,insertdata.name());
            stmt.setInt(3,insertdata.price());
            num = stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return num;

    }

    public int update(ProductRecord insertdata) {

        final var SQL = "UPDATE products SET name = ?,price = ? WHERE id = ?";

        int num;

        try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            stmt.setString(1,insertdata.name());
            stmt.setInt(2,insertdata.price());
            stmt.setInt(3,insertdata.id());
            num = stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return num;

    }

    public int delete(int delete_id) {

        final var SQL = "DELETE FROM products WHERE id = ?";

        int num;

        try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            stmt.setInt(1,delete_id);
            num = stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return num;

    }


}