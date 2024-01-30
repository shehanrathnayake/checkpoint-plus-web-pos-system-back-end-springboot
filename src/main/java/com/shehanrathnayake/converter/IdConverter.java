package com.shehanrathnayake.converter;

import org.springframework.stereotype.Component;

@Component
public class IdConverter {
    public int convertCustomerIdToInt(String customerId) {
        return Integer.parseInt(customerId.substring(1));
    }

    public String convertIntToCustomerId(Integer id) {
        return String.format("C%06d", id);
    }

    public int convertUserIdToInt(String userId) {
        return Integer.parseInt(userId.substring(1));
    }

    public String convertIntToUserId(Integer id) {
        return String.format("U%06d", id);
    }
}
