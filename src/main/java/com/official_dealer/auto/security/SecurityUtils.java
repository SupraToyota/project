package com.official_dealer.auto.security;

import org.springframework.security.core.context.SecurityContextHolder;

import com.official_dealer.auto.entity.Dealer;

public final class SecurityUtils {

    private SecurityUtils() {
    }

    public static Dealer getCurrentDealer() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var userDetails = (UserDetailsImpl) auth.getPrincipal();
        return userDetails.getUser().getDealer();
    }
}
