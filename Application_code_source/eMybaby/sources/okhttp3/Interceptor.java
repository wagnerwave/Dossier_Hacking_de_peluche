package okhttp3;

public interface Interceptor {

    public interface Chain {
        Connection connection();

        Response proceed(Request request);

        Request request();
    }

    Response intercept(Chain chain);
}
