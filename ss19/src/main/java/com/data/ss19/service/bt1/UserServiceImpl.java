package com.data.ss19.service.bt1;

import com.data.ss19.entity.bt1.User;
import com.data.ss19.repository.bt1.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public long countSearchCustomers(String keyword) {
        return userRepository.countSearchCustomers(keyword);
    }

    @Override
    public User getCustomerByUsername(String username) {
        return userRepository.getCustomerByUsername(username);
    }

    @Override
    public List<User> getAllCustomers(int pageNumber, int pageSize) {
        return userRepository.getAllCustomers(pageNumber, pageSize);
    }

    @Override
    public long totalCustomersCount() {
        return userRepository.totalCustomersCount();
    }

    @Override
    public void updateStatus(int id, boolean status) {
        userRepository.updateStatus(id, status);
    }

    @Override
    public void updateCustomer(User customer) {
        userRepository.updateCustomer(customer);
    }

    @Override
    public User getCustomerById(int id) {
        return userRepository.getCustomerById(id);
    }

    @Override
    public List<User> searchCustomers(String keyword, int page, int size) {
        return userRepository.searchCustomers(keyword, page, size);
    }
}
