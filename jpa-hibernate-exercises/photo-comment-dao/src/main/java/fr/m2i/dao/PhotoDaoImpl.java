package fr.m2i.dao;

import fr.m2i.model.Photo;
import fr.m2i.util.EntityManagerUtil;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PhotoDaoImpl implements PhotoDao {
    private EntityManagerUtil emUtil;

    public PhotoDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.emUtil = new EntityManagerUtil(entityManagerFactory);
    }

    @Override
    public void save(Photo photo) {
        throw new UnsupportedOperationException("Just do it!"); // todo
    }

    @Override
    public Photo findById(long id) {
        throw new UnsupportedOperationException("Just do it!"); // todo
    }

    @Override
    public List<Photo> findAll() {
        throw new UnsupportedOperationException("Just do it!"); // todo
    }

    @Override
    public void remove(Photo photo) {
        throw new UnsupportedOperationException("Just do it!"); // todo
    }

    @Override
    public void addComment(long photoId, String comment) {
        throw new UnsupportedOperationException("Just do it!"); // todo
    }
}
