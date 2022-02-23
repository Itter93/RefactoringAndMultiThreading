import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


public class Request {
    private List<NameValuePair> queryParams;
    private String url;

    public Request(String url) {
        this.url = url;
        this.queryParams = parseQueryParams();
    }

    private List<NameValuePair> parseQueryParams() {
        try {
            return URLEncodedUtils.parse(new URI(url), "UTF-8");
        } catch (URISyntaxException ex) {
            throw new AssertionError(ex);
        }
    }


    public  List<NameValuePair> getQueryParams() {
        return queryParams;
    }

    public List<NameValuePair> getQueryParam(String name) {
        return queryParams.stream()
                .filter(o -> o.getName().equals(name))
                .toList();
    }

}
