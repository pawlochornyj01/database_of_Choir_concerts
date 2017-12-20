package ua.com.dudaryk.repository.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Category;
import ua.com.dudaryk.repository.AbstractDAOImpl;
import ua.com.dudaryk.repository.interfaces.CategoryDAO;

@Repository
@Transactional
public class CategoryDAOImpl extends AbstractDAOImpl<Category> implements CategoryDAO {

    @Override
    public void setClazz(Class<Category> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    //чи не кастити а лишити шо бметод повертав просто обджект?
    @Transactional(readOnly = true)
    @Override
    public Category findByDudarykId(Long id) {
        String query = "select Category from category  where Category.DUDARYK_ID=" + id;
        return (Category) entityManager.createQuery(query).getSingleResult();
    }
}
