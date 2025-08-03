package domain.port.in;

import java.net.http.HttpResponse;

public interface RegisterUserUseCase<T> {
    public HttpResponse<T> CheckUser();
    public HttpResponse<T> RegisterUser();
}
