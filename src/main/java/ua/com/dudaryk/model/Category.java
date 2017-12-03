package ua.com.dudaryk.model;


import javax.persistence.*;

@Entity
@Table(name = "category")
class Category {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private int categoryId;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "DUDARYK_ID")
    private Dudaryk dudaryk;


    public Dudaryk getDudaryk() {
        return dudaryk;
    }

    public void setDudaryk(Dudaryk dudaryk) {
        this.dudaryk = dudaryk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}
