package DBAccess_Ensyu01;

import java.util.List;

public class ProductService {

    private ProductDao productdao;

    public ProductService() {
        var connection = DBUtil.getConnection();
        // DBUtilのgetConnectionメソッドを使用し、DBに接続
        productdao = new ProductDao(connection);
        // 接続した後、ProductDao内でDBに接続できるようにする。
    }

    public ProductRecord findById(int fbi) {
        var idrecord = productdao.findById(fbi);
        if (idrecord == null) {
            throw new  ProductNotFoundException();
        }
        return idrecord;
    }

    public List<ProductRecord> findByName(String fbn) {
        var namerecord = productdao.findByName(fbn);
        return namerecord;
    }

    public int insert(ProductRecord insertdata) {
        var insert = productdao.insert(insertdata);
        return insert;
    }

    public int update(ProductRecord updatedata) {
        var update = productdao.update(updatedata);
        return update;
    }

    public int delete(int delete_id) {
        var delete = productdao.delete(delete_id);
        return delete;
    }

}
