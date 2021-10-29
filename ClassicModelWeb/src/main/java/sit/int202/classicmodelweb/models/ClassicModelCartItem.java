package sit.int202.classicmodelweb.models;

import sit.int202.classicmodelweb.entities.Product;

public class ClassicModelCartItem implements CartItem {
    private Product product;
    private int quantity;
    private double percentDiscount;

    public ClassicModelCartItem(Product product, int quantity, double percentDiscount) {
        this.product = product;
        this.quantity = quantity;
        this.percentDiscount = percentDiscount;
    }

    public Product getProduct() {
        return this.product;
    }

    public ClassicModelCartItem(Product product) {
        this(product, 1, 0);
    }

    public ClassicModelCartItem(Product product, int quantity) {
        this(product, quantity, 0);
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getUnitPrice() {
        return product.getMsrp().doubleValue();
    }

    @Override
    public double getTotal() {
        double discount = (getUnitPrice() * getQuantity()) * percentDiscount;
        return (getUnitPrice() * getQuantity()) - discount;
    }

    @Override
    public double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClassicModelCartItem {");
        sb.append("product = ").append(product);
        sb.append(", quantity = ").append(quantity);
        sb.append(", percentDiscount = ").append(percentDiscount);
        sb.append("%}");
        return sb.toString();
    }
}
