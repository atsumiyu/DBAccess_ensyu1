package DBAccess_Ensyu01;

public class Main {
    public static void main(String[] args) {

        var userService = new ProductService();

        // ProductServiceにDBに接続させる
        var id = userService.findById(104);
        System.out.println(id);

//        var name = userService.findByName("消");
//        System.out.println(name);

//        var insert_data = new ProductRecord(104,"シャーペン",200);
//        userService.insert(insert_data);

//        var update_data = new ProductRecord(104,"ボールペン",150);
//        userService.update(update_data);

//        var delete_id = userService.delete(104);

    }
}
