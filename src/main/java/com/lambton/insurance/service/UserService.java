package com.lambton.insurance.service;

import com.lambton.insurance.dao.UserDao;
import com.lambton.insurance.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return new ResponseEntity<>(userDao.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<User> getUserById(Integer userId) {
        try {
            Optional<User> user = userDao.findById(userId);
            return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<User> createUser(User user) {
        try {
            return new ResponseEntity<>(userDao.save(user), HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<User> updateUser(Integer userId, User updatedUser) {
        try {
            Optional<User> existingUser = userDao.findById(userId);
            if (existingUser.isPresent()) {
                User userToUpdate = existingUser.get();
                userToUpdate.setFirstName(updatedUser.getFirstName());
                userToUpdate.setLastName(updatedUser.getLastName());
                userToUpdate.setDateOfBirth(updatedUser.getDateOfBirth());
                userToUpdate.setGender(updatedUser.getGender());
                userToUpdate.setContactNumber(updatedUser.getContactNumber());
                userToUpdate.setEmail(updatedUser.getEmail());
                userToUpdate.setAddress(updatedUser.getAddress());
                userToUpdate.setUserType(updatedUser.getUserType());
                return new ResponseEntity<>(userDao.save(userToUpdate), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Return empty if an exception occurs
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteUser(Integer userId) {
        try {
            if (userDao.existsById(userId)) {
                userDao.deleteById(userId);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                // Return a 404 Not Found response if the user doesn't exist
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}