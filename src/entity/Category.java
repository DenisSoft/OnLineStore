package entity;

/**
 * Created by Dzianis on 07.04.2017.
 */
public class Category extends BaseEntity{
    private String categoryName;
    private String errors;

    public Category() {
        this.categoryName = "";
        errors = "";
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(long id, String categoryName) {
        super(id);
        this.categoryName = categoryName;
    }

    public boolean validate() {
        if (categoryName.equals("")) {
            this.errors = "Пожалуйста, введите название категории!";
            return false;
        }
        return true;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return getId() == category.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }

    @Override
    public String toString() {
        return categoryName;
    }
}
