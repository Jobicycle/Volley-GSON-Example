package justin.volley_gson_sample;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class VolleyService {
    private Context mContext;

    public VolleyService(Context context) {
        mContext = context;
    }

    public void getDataVolley(String url, final VolleyCallback callback) {
        try {
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            callback.onSuccessResponse(response);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError e) {
                            callback.onErrorResponse(e);
                        }
                    });

            MySingleton.getInstance(mContext).addToRequestQueue(jsonObjReq);

        } catch (Exception e) {
        }
    }
}
