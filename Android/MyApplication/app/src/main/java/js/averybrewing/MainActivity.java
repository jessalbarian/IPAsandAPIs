package js.averybrewing;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new URLDataDownloadBeer().execute("http://apis.mondorobot.com/beers?");
    }



    public class URLDataDownloadBeer extends URLDataDownload {

        public URLDataDownloadBeer() {
            progressDialog = new ProgressDialog(MainActivity.this);
        }

        /**
         * onPostExecute shows website data
         */
        protected void onPostExecute(Void v) {
            progressDialog.dismiss();
            try {
                JSONArray jArray = new JSONArray(result);
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject beer = jArray.getJSONObject(i);
                    createBeer(beer);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            // Test: prints entire JSON
//            TextView messageView = new TextView(MainActivity.this);
//            messageView.setText(result);
//            LinearLayout dogLayout = (LinearLayout) findViewById(R.id.linearBeers);
//            dogLayout.addView(messageView);

        }



        // creates "beer" objects which consist of the image
        // and other info about a beer
        public void createBeer(JSONObject beer){

            // Creates objects for beers
//            ImageView image = new ImageView(MainActivity.this);

            TextView name = new TextView(MainActivity.this);
            TextView style = new TextView(MainActivity.this);
            TextView abv = new TextView(MainActivity.this);



            try {
//                // Gets strings from JSON Array (See onPostExecute)
//                // Converts image url into base64
//                byte[] decodedString = Base64.decode(small.getString("image"), Base64.DEFAULT);
//                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
//                image.setImageBitmap(decodedByte);



                name.setText(beer.getString("name"));
                style.setText(beer.getString("sex"));
                abv.setText("ABV: " + beer.getString("code"));


                name.setTextColor(Color.parseColor("#000000"));
                style.setTextColor(Color.parseColor("#000000"));
                abv.setTextColor(Color.parseColor("#000000"));

                //add formatting
//                id.setPadding(0, 0, 0, 75);

                //image formatting
//                image.setMaxWidth(550);
//                image.setMaxHeight(550);
//                image.setPadding(0, 75, 0, 0);

                //text formatting
                name.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                style.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                abv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);


                //status formatting
                name.setTextSize(20);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            // Creates views for each small animal
            LinearLayout beers = (LinearLayout) findViewById(R.id.linearBeers);
//            beers.addView(image);
            beers.addView(name);
            beers.addView(style);
            beers.addView(abv);
        }
    }
}
