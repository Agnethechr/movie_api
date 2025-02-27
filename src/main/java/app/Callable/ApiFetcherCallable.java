package app.Callable;
import app.Services.MovieService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import app.DTO.MediaDTO;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ApiFetcherCallable implements Callable<List<MediaDTO>> {
    MovieService movieService = new MovieService();

    private final String apiUrl;

    public ApiFetcherCallable(String apiUrl){
        this.apiUrl = apiUrl;
    }


    public void runAllUrl() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> futureList = new ArrayList<>();

        String response = movieService.getDataFromURL(apiUrl);

        if(response != null && !response.isEmpty()) {
            Callable task = new ApiFetcherCallable(response);
            Future<String> future = executorService.submit(task);
            futureList.add(future);
        } else {
            System.out.println("API returnerede ingen data.");
        }

        System.out.println("Antal tasks: " + futureList.size());
        executorService.shutdown();
    }



    @Override
    public List<MediaDTO> call() throws Exception {
        return List.of();
    }
}
