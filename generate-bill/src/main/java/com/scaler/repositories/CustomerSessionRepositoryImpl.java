package com.scaler.repositories;

import com.scaler.models.CustomerSession;
import com.scaler.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CustomerSessionRepositoryImpl implements CustomerSessionRepository{

    private Map<Long, CustomerSession> customerSessionMap;
    private static long idCounter = 0;

    public CustomerSessionRepositoryImpl() {
        customerSessionMap = new HashMap<>();
    }

    @Override
    public CustomerSession save(CustomerSession customerSession) {
        if(customerSession.getId() == 0){
            customerSession.setId(++idCounter);
        }
        customerSessionMap.put(customerSession.getId(), customerSession);
        return customerSession;
    }
    @Override
    public Optional<CustomerSession> findActiveCustomerSessionByUserId(long userId) {

        return customerSessionMap.values().stream().filter(customerSession -> customerSession.getUser().getId() == userId && customerSession.isActive()).findFirst();
    }

}
