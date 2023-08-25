package com.cg.utils;

import com.cg.model.ERole;
import com.cg.model.User;

public class AuthUtils {

    private static User user;

    public static void setUserAuthentication(User user) {
        AuthUtils.user = user;
    }

    public static boolean hasRole(ERole role){
        return user.getRole().equals(role);
    }
}
