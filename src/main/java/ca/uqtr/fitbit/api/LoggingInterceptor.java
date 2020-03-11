package ca.uqtr.fitbit.api;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.logging.Logger;

public class LoggingInterceptor implements Interceptor {

    private static Logger logger = Logger.getLogger(LoggingInterceptor.class.getName());

    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();
//        logger.info(String.format("Sending request: %s \nBody: %s \nHeaders: %s",
//                request.url(), request.body(), request.headers()));
        logger.info("Sending request:  " + request.url());

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();
//        logger.info(String.format("Received response for %s in %.1fms%n%s",
//                response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        logger.info(String.format("Received response for %s in %.1fms%n",
                response.request().url(), (t2 - t1) / 1e6d));

        return response;
    }
}
