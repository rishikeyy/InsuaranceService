package port.in;

import java.net.http.HttpResponse;

public interface UserInterface<T> {
    public HttpResponse<T> CheckUser();
    public HttpResponse<T> RegisterUser();
}
