package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repo.FakeRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final FakeRepoInterface fakeRepo;

    @Autowired
    public UserServiceImpl(FakeRepoInterface fakeRepo) {
        this.fakeRepo = fakeRepo;
    }

    @Override
    public void addUser(String name, String surname) {
        long id = System.currentTimeMillis(); // Generate unique ID
        String addedName = fakeRepo.insertUser(id, name, surname);
        System.out.println(addedName + " added");
    }

    @Override
    public void removeUser(long id) {
        String removedName = fakeRepo.deleteUser(id);
        if (removedName != null) {
            System.out.println(removedName + " removed");
        } else {
            System.out.println("User not found");
        }
    }

    @Override
    public void getUser(long id) {
        User user = fakeRepo.findUserById(id);
        if (user != null) {
            System.out.println("hello " + user.getName());
        } else {
            System.out.println("User not found");
        }
    }
}