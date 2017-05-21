package entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dzianis on 28.03.2017.
 */
public class Product extends BaseEntity{
    private Category category;
    private String productName;
    private String description;
    private int price;
    private int residue;
    private Map errors;

    public Product() {
        this.category = new Category();
        this.productName = "";
        this.description = "";
        this.errors = new HashMap();
    }

    public Product(long id) {
        super(id);
    }

    public Product(long id, String productName) {
        super(id);
        this.productName = productName;
    }

    public Product(Long id, String productName, int price) {
        super(id);
        this.productName = productName;
        this.price = price;
    }

    public Product(Category category, String productName, String description, int price, int residue) {
        this.category = category;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.residue = residue;
    }

    public Product(Long id, Category category, String productName, String description, int price, int residue) {
        super(id);
        this.category = category;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.residue = residue;
    }

    public boolean validate() {
        boolean allOk = true;
        setDescription(description.trim());
        if (category.getCategoryName().equals("")) {
            errors.put("category", "Пожалуйста, выберите категорию!");
            category.setCategoryName("");
            allOk = false;
        }
        if (productName.equals("")) {
            errors.put("productName", "Пожалуйста, введите название!");
            productName = "";
            allOk = false;
        }
        if (description.equals("")) {
            errors.put("description", "Пожалуйста, добавьте описание!");
            description = "";
            allOk = false;
        }
        if (price == 0) {
            errors.put("price", "Пожалуйста, введите цену!");
            price = 0;
            allOk = false;
        }
        if (residue == 0) {
            errors.put("residue", "Пожалуйста, введите количество!");
            residue = 0;
            allOk = false;
        }
        return allOk;
    }

    public String getErrorMsg(String s) {
        String errorMsg = (String) errors.get(s.trim());
        return (errorMsg == null) ? "" : errorMsg;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getResidue() {
        return residue;
    }

    public void setResidue(int residue) {
        this.residue = residue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return getId() == product.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }

    @Override
    public String toString() {
        return "ProductServlet{" +
                "id=" + getId() +
                ", category=" + category +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", residue=" + residue +
                ", errors=" + errors +
                '}';
    }
}
