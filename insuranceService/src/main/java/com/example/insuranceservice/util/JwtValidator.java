package com.example.insuranceservice.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtValidator {

    public static boolean validate(String token) {

        try {

            DecodedJWT jwt = JWT.decode(token);

            // Check expiration
            if (jwt.getExpiresAt().before(new java.util.Date())) {
                return false;
            }

            // Check issuer
            String issuer = jwt.getIssuer();

            if (!issuer.contains("cognito-idp")) {
                return false;
            }

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}