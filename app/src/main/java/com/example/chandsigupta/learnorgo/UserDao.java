package com.example.chandsigupta.learnorgo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user where name LIKE  :name AND email LIKE :email")
    User findByName(String name, String email);

    @Query("SELECT COUNT(*) from user")
    int countUsers();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}