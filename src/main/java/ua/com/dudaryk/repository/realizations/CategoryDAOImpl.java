package ua.com.dudaryk.repository.realizations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.repository.AbstractGenericDAOImpl;
import ua.com.dudaryk.repository.interfaces.CategoryDAO;

@Repository
@Transactional
public class CategoryDAOImpl<Category> extends AbstractGenericDAOImpl<Category> implements CategoryDAO {

    @Override
    public void setClazz(Class<Category> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    @Transactional(readOnly = true)
    @Override
    public Object findByDudarykId(Long id) {
        String query = "select Category from category  where Category.DUDARYK_ID=" + id;
        return entityManager.createQuery(query).getSingleResult();
    }
}
