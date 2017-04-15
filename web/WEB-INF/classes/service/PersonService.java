package service;

import dao.PersonDao;
import entity.Person;

import java.util.List;
import java.util.Optional;

/**
 * Created by Dzianis on 13.04.2017.
 */
public class PersonService {
    private static final Object LOCK = new Object();
    private static PersonService INSTANCE = null;

    public static PersonService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new PersonService();
                }
            }
        }
        return INSTANCE;
    }

    public static boolean delete(long id) {
        return PersonDao.getInstance().delete(id);
    }

    public static Optional<Person> getById(long id) {
        Optional<Person> fullInfo = PersonDao.getInstance().getById(id);
        if (fullInfo.isPresent()) {
            return fullInfo;
        }
        return Optional.empty();
    }

    public static Optional<Person> save(Person person) {
        Optional<Person> fullInfo = PersonDao.getInstance().save(person);
        if (fullInfo.isPresent()) {
            return fullInfo;
        }
        return Optional.empty();
    }

    public static Optional<List<Person>> getAll() {
        Optional<List<Person>> fullInfo = PersonDao.getInstance().getAll();
        if (fullInfo.isPresent()) {
            return fullInfo;
        }
        return Optional.empty();
    }
}
