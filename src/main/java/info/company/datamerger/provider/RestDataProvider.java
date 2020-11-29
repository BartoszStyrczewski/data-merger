package info.company.datamerger.provider;

import io.vavr.CheckedFunction1;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.function.Function;

import static info.company.datamerger.provider.HttpBodyParser.intParser;
import static info.company.datamerger.provider.HttpBodyParser.stringParser;
import static info.company.datamerger.provider.RestEndpoints.INT;
import static info.company.datamerger.provider.RestEndpoints.STRING;
import static java.util.logging.Level.SEVERE;

@Log
@RequiredArgsConstructor
public class RestDataProvider<D> implements DataProvider<D> {

  @NonNull private final String URI;
  @NonNull private final Function<String, D> responseParser;

  public static RestDataProvider<Integer> intDataProvider() {
    return new RestDataProvider<>(INT, intParser());
  }

  public static RestDataProvider<String> stringDataProvider() {
    return new RestDataProvider<>(STRING, stringParser());
  }

  private Try<HttpRequest> getRequest() {
    return Try.of(
        () ->
            HttpRequest.newBuilder()
                .uri(new URI(this.URI))
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build());
  }

  private Option<String> send() {
    return getRequest()
        .flatMap(
            CheckedFunction1.liftTry(
                req ->
                    HttpClient.newHttpClient()
                        .send(req, HttpResponse.BodyHandlers.ofString())
                        .body()))
        .onFailure(t -> log.log(SEVERE, "Rest connection error, URI: " + this.URI))
        .toOption();
  }

  @Override
  public Option<D> get() {
    return send()
        .flatMap(
            response ->
                Try.of(() -> responseParser.apply(response))
                    .onFailure(t -> log.log(SEVERE, "Response parse error: " + t))
                    .toOption());
  }
}
