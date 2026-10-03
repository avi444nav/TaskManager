package com.abhinav.task_manager.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.abhinav.task_manager.repository.UserRepository;
import com.abhinav.task_manager.model.User;
import java.util.List;
import java.util.Optional;
import com.abhinav.task_manager.exception.ResourceNotFoundException;
@Service    
public class UserService {
    @Autowired 
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
}

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

