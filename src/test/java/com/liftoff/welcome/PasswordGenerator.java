package com.liftoff.welcome;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "111111";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(rawPassword);
        System.out.println(encodedPassword);
    }
}


//  2a10F47xKtCXMYVoJ57fsi0nVzoUZOmgf7pgbboAbDDjPds3X4mKAK      Spring Security ---  remember-me key




