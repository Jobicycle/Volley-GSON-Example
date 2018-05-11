package justin.volley_gson_sample;

import com.android.volley.VolleyError;

import org.json.JSONObject;

public interface VolleyCallback {
    void onSuccessResponse(JSONObject response);

    void onErrorResponse(VolleyError error);
}
