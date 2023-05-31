package com.example.restaurantList.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {

    private final List<T> db = new ArrayList<>();
    private int index = 0;

    @Override
    public Optional<T> findById(int index) {
        // filter는 db.stream에 들어있는 Optional<T>, type에 대한 filter이다.
        // 그래서 it.getIndex는 MemoryDbEntity에 정의된 index를 가리킨다.
        return db.stream().filter(it -> it.getIndex() == index).findFirst();

    }

    private Predicate<T> same(int index) {
        return it -> it.getIndex() == index;

    }

    @Override
    public T save(T entity) {

        // arraylist는 stream()을 사용해서 리스트 내 값을 하나하나 emit? 하고 control할 수 있음..
        var optionalEntity = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();
        // optionalEntity = Optional.of(null or foundEntity);

        if (optionalEntity.isEmpty()) {
            // db에 데이터가 없는 경우
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;
        } else {
            // db에 이미 데이터가 있는 경우, 기존에 존재하던 데이터를 지운 뒤 새로운 데이터로 업데이트

            var preIndex = optionalEntity.get().getIndex();
            entity.setIndex(preIndex);

            deleteById(preIndex);
            db.add(entity);
            return entity;
        }

    }

    @Override
    public void deleteById(int index) {
        var optionalEntity = db.stream().filter(it -> it.getIndex() == index).findFirst();
        if (optionalEntity.isPresent()) {
            db.remove(optionalEntity.get());
        }

    }

    @Override
    public List<T> listAll() {
        return db;
    }
}
