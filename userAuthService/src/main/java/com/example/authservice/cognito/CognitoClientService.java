package com.example.authservice.cognito;

import com.example.authservice.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class CognitoClientService {

    @Value("${aws.cognito.clientId}")
    private String clientId;

    @Value("${aws.cognito.region}")
    private String region;

    public LoginResponse authenticate(String username, String password) {

        CognitoIdentityProviderClient cognitoClient =
                CognitoIdentityProviderClient.builder()
                        .region(Region.of(region))
                        .build();

        Map<String, String> authParams = new HashMap<>();
        authParams.put("USERNAME", username);
        authParams.put("PASSWORD", password);

        InitiateAuthRequest authRequest =
                InitiateAuthRequest.builder()
                        .authFlow(AuthFlowType.USER_PASSWORD_AUTH)
                        .clientId(clientId)
                        .authParameters(authParams)
                        .build();

        try {

            InitiateAuthResponse response =
                    cognitoClient.initiateAuth(authRequest);

            AuthenticationResultType result =
                    response.authenticationResult();

            LoginResponse loginResponse = new LoginResponse();

            loginResponse.setAccessToken(result.accessToken());
            loginResponse.setIdToken(result.idToken());
            loginResponse.setRefreshToken(result.refreshToken());
            loginResponse.setMessage("Login successful");

            return loginResponse;

        } catch (CognitoIdentityProviderException e) {

            return new LoginResponse("Invalid username or password");
        }
    }
}