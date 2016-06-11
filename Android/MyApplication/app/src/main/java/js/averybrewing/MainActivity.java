package js.averybrewing;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
//                    createSmall(beer);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            // Test: prints entire JSON
            TextView messageView = new TextView(MainActivity.this);
            messageView.setText(result);
            LinearLayout dogLayout = (LinearLayout) findViewById(R.id.linearBeers);
            dogLayout.addView(messageView);

        }



        // creates "small animal" objects which consist of the image
        // and other info about a small
//        public void createSmall(JSONObject small){
//
//            // Creates objects for dogs
//            ImageView image = new ImageView(DogActivity.this);
//            TextView status = new TextView(DogActivity.this);
//            TextView name = new TextView(DogActivity.this);
//            TextView breed = new TextView(DogActivity.this);
//            TextView age = new TextView(DogActivity.this);
//            TextView sex = new TextView(DogActivity.this);
//            TextView id = new TextView(DogActivity.this);
//
//
//            try {
//                // Gets strings from JSON Array (See onPostExecute)
//                // Converts image url into base64
//                byte[] decodedString = Base64.decode(small.getString("image"), Base64.DEFAULT);
//                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
//                image.setImageBitmap(decodedByte);
//
//                status.setText(small.getString("status").toUpperCase());
//                name.setText("Name: " + small.getString("name"));
//                breed.setText("Breed: " + small.getString("breed") + " " + small.getString("pedigree"));
//                age.setText("Age: " + small.getString("age"));
//                sex.setText("Sex: " + small.getString("sex"));
//                id.setText("ID: " + small.getString("code"));
//
//
//                name.setTextColor(Color.parseColor("#000000"));
//                breed.setTextColor(Color.parseColor("#000000"));
//                age.setTextColor(Color.parseColor("#000000"));
//                sex.setTextColor(Color.parseColor("#000000"));
//                id.setTextColor(Color.parseColor("#000000"));
//
//                //add formatting
//                id.setPadding(0, 0, 0, 75);
//
//                //image formatting
//                image.setMaxWidth(550);
//                image.setMaxHeight(550);
//                image.setPadding(0, 75, 0, 0);
//
//                //text formatting
//                status.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
//                name.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
//                breed.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
//                age.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
//                sex.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
//                id.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
//
//                //status formatting
//                status.setTextSize(20);
//                if (small.getString("status").toLowerCase().equals("on hold")){
//                    status.setTextColor(Color.parseColor("#303F9F"));
//                } else {
//                    status.setTextColor(Color.parseColor("#EF8200"));
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            // Creates views for each small animal
//            LinearLayout smalls = (LinearLayout) findViewById(R.id.linearDogs);
//            smalls.addView(image);
//            smalls.addView(status);
//            smalls.addView(name);
//            smalls.addView(breed);
//            smalls.addView(age);
//            smalls.addView(sex);
//            smalls.addView(id);
//        }
    }
}
