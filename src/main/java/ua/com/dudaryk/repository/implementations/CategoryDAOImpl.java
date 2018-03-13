package ua.com.dudaryk.repository.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Category;
import ua.com.dudaryk.repository.AbstractDAOImpl;
import ua.com.dudaryk.repository.interfaces.CategoryDAO;

import javax.annotation.PostConstruct;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CategoryDAOImpl extends AbstractDAOImpl<Category> implements CategoryDAO {

    @PostConstruct
    private void init() {
        setClazz(Category.class);
    }

    @Override
    public Category saveCategory(Category category) {
        return save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return update(category);
    }

    @Override
    public List<Category> findAllCategory() {
        return findAll();
    }

    //чи не кастити а лишити шо бметод повертав просто обджект?

    @Override
    public Category findByDudarykId(int id) {
        TypedQuery<Category> query = entityManager.createQuery(
                "select c from Category c " +
                        " where c.categoryId = :id", Category.class);
        return query.setParameter("id", id).getSingleResult();
    }


    @Override
    public void deleteCategory(Category category) {
        category = entityManager.contains(category) ? category : findById(category.getCategoryId());
        super.delete(category);
    }


}
