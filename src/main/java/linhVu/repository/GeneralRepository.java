package linhVu.repository;

import java.util.List;

public interface GeneralRepository<E> {
    List<E> findAll();

    E findById(int id);

    List<E>findByName(String name);

    void save(E e);

    void update(int id,E e);

    void remove(int id);

}
