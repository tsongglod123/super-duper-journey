package sit.int202.classicmodelweb;

import sit.int202.classicmodelweb.entities.Product;
import sit.int202.classicmodelweb.models.Cart;
import sit.int202.classicmodelweb.models.ClassicModelCartItem;
import sit.int202.classicmodelweb.repositories.ProductRepo;

public class Test {
    public static void main(String[] args) {
        Cart<String, ClassicModelCartItem> cart = new Cart<>();
        ProductRepo productRepository = new ProductRepo();
        Product product = productRepository.findProduct("S10_1678");
        cart.addItem(product.getId(), new ClassicModelCartItem(product, 5));
        product = productRepository.findProduct("S12_3380");
        cart.addItem(product.getId(), new ClassicModelCartItem(product));
        System.out.println(cart.countItem());
        System.out.println(cart.countQuantity());
        System.out.println(cart.getTotalPrice());
        System.out.println(cart.getAllItems());
        cart.removeItem("S10_1678");
        System.out.println(cart.countItem());
        System.out.println(cart.countQuantity());
        System.out.println(cart.getTotalPrice());
        System.out.println(cart.getAllItems());
    }
}
