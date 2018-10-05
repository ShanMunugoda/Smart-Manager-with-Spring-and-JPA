package lk.ijse.comp.dao;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class CrudDAOImpl<T,ID> implements CrudDAO<T,ID> {

    @PersistenceContext
    protected EntityManager entityManager;
    private Class<T> entity;

    public CrudDAOImpl() {
        entity = (Class<T>)(((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public void Save(T entity) throws Exception {

        entityManager.persist(entity);
    }

    @Override
    public void Update(T entity) throws Exception {
        entityManager.persist(entity);
    }

    @Override
    public void Delete(ID id) throws Exception {
        T t = entityManager.find(entity, id);
        entityManager.remove(t);

    }

    @Override
    public List<T> getAll() throws Exception {
        return entityManager.createQuery("FROM "+ entity.getName()).getResultList();
    }

    @Override
    public T findById(ID id) throws Exception {
       return entityManager.find(entity,id);
    }


}
