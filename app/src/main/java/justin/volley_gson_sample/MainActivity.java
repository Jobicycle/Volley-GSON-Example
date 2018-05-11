package justin.volley_gson_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.VolleyError;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    VolleyService mVolleyService = new VolleyService(this);
    String url = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=CAD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getAllJsonData();
    }

    /**
     * use the volleyService with the above URL and an anonymous inner callback class that will
     * trigger when volley returns the data or an error.
     * TODO: look into timeout/retry logic.
     */
    private void getAllJsonData() {
        mVolleyService.getDataVolley(url, new VolleyCallback() {
            @Override
            public void onSuccessResponse(JSONObject response) { // we can do stuff with the response once it is returned here.
                JSONObject fetchedJsonData = response;
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("MainActivity", error.toString());
            }
        });
    }
}