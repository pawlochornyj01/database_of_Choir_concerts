package ua.com.dudaryk.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Dudaryk;

import java.io.Serializable;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl<Category extends Serializable> extends AbstractGenericDAOImpl<Category> implements CategoryDAO {

    @Override
    public void setClazz(Class<Category> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    @Transactional(readOnly = true)
    @Override
    public Object findByDudaryk(Long id) {
        String sql = "select Category from category  where Category.DUDARYK_ID=" + id;
        return entityManager.createQuery(sql).getSingleResult();
    }
}
