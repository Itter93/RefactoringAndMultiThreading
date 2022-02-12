import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
    private Map<String, String> params = new HashMap<>();

    public Map<String, String> getParams() {
        return params;
    }

    public Map<String, String> getQueryParams(String url) {
        try {
            List<NameValuePair> param = URLEncodedUtils.parse(new URI(url), "UTF-8");
            for (NameValuePair parameter : param) {
                if (!(parameter.getName().isEmpty() && parameter.getValue().isEmpty()))
                    params.put(parameter.getName(), parameter.getValue());
            }
            return params;
        } catch (URISyntaxException ex) {
            throw new AssertionError(ex);
        }
    }


    public String getQueryParam(String name) {
        return params.get(name);
    }

}
