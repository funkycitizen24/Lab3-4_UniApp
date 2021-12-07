package com.company.repository;
import java.util.ArrayList;
import java.util.List;


public abstract class InMemoryRepository<T> implements ICrudRepository<T> {
    protected List<T> repoList;

    public InMemoryRepository() {
        this.repoList = new ArrayList<>();
    }

    public List<T> getAll() {
        return this.repoList;
    }
}
