package app.daos;

import java.util.List;

public interface IDAO<T,ID> {
    T create(T entity);
    T update(T entity);
    void delete(ID id);
    List<T> getAll();
    T getById(ID id);
}
