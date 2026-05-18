package test.java.com.example.authservice.service;

import com.example.authservice.cognito.CognitoClientService;
import com.example.authservice.dto.LoginRequest;
import com.example.authservice.dto.LoginResponse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AuthServiceTest {

    @Test
    void testLoginSuccess() {

        // Mock Cognito Service
        CognitoClientService cognitoClientService =
                Mockito.mock(CognitoClientService.class);

        // Request Object
        LoginRequest request = new LoginRequest();
        request.setUsername("testuser");
        request.setPassword("password");

        // Mock Response
        LoginResponse mockResponse = new LoginResponse();
        mockResponse.setMessage("Login successful");

        Mockito.when(
                cognitoClientService.authenticate(
                        "testuser",
                        "password"
                )
        ).thenReturn(mockResponse);

        // Service
        AuthService authService = new AuthService();

        // Inject Mock
        try {
            java.lang.reflect.Field field =
                    AuthService.class.getDeclaredField("cognitoClientService");

            field.setAccessible(true);
            field.set(authService, cognitoClientService);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Call Method
        LoginResponse response = authService.login(request);

        // Assertions
        Assertions.assertNotNull(response);
        Assertions.assertEquals(
                "Login successful",
                response.getMessage()
        );
    }
}