package js.averybrewing;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

public class EventActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

//        TextView title = new TextView(findViewById(R.id.eventTitle));

        new URLDataDownloadEvent().execute("http://apis.mondorobot.com/events");
    }


    public class URLDataDownloadEvent extends URLDataDownload {

        public URLDataDownloadEvent() {
            progressDialog = new ProgressDialog(EventActivity.this);
        }

        /**
         * onPostExecute shows website data
         */
        protected void onPostExecute(Void v) {
            progressDialog.dismiss();
            try {

                JSONArray jArray = new JSONArray(new JSONObject(result).getString("events"));
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject event = jArray.getJSONObject(i);
                    createEvent(event);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // creates "beer" objects which consist of the image
        // and other info about a beer
        public void createEvent(JSONObject event) throws JSONException, IOException {

            // Creates objects for beers
            ImageView image = new ImageView(EventActivity.this);

            final TextView title = new TextView(EventActivity.this);
            TextView description = new TextView(EventActivity.this);
            TextView location = new TextView(EventActivity.this);
            TextView starts_at = new TextView(EventActivity.this);
            TextView ticket_url = new TextView(EventActivity.this);


            final String mytitle = event.getString("title");
            final String mydescription = event.getString("description");
            final String mylocation = event.getString("location");
            final String mystarts_at = event.getString("starts_at");
            final String myticket_url = event.getString("ticket_url");


            // Default time zone.
            DateTime dateTime = new DateTime(mystarts_at);


            // Output in localized format.
            DateTimeFormatter formatter = DateTimeFormat.shortDateTime().withLocale( Locale.US );
            String output_US = formatter.print(dateTime);

            title.setText(event.getString("title"));
            description.setText(event.getString("description"));
            location.setText("Where: " + event.getString("location"));
            starts_at.setText(event.getString(output_US));
            if (event.getString("ticket_url") != null) {
                ticket_url.setText(event.getString("ticket_url"));
            }


            title.setTextColor(Color.parseColor("#000000"));
            description.setTextColor(Color.parseColor("#000000"));
            location.setTextColor(Color.parseColor("#000000"));
            starts_at.setTextColor(Color.parseColor("#000000"));
            ticket_url.setTextColor(Color.parseColor("#000000"));

            //add formatting

            title.setPadding(50, 0, 0, 50);
            description.setPadding(50, 0, 0, 25);
            location.setPadding(50, 0, 0, 25);
            starts_at.setPadding(50, 0, 0, 25);
            ticket_url.setPadding(50, 0, 0, 250);

            //image formatting
            image.setMaxWidth(550);
            image.setMaxHeight(550);
            image.setPadding(0, 75, 0, 0);

            //text formatting
            title.setGravity(Gravity.CENTER_VERTICAL);
            description.setGravity(Gravity.CENTER_VERTICAL);
            location.setGravity(Gravity.CENTER_VERTICAL);
            starts_at.setGravity(Gravity.CENTER_VERTICAL);
            ticket_url.setGravity(Gravity.CENTER_VERTICAL);


            //status formatting
            title.setTextSize(25);
            location.setTextSize(20);
            starts_at.setTextSize(20);


            // Creates views for each small animal
            LinearLayout beers = (LinearLayout) findViewById(R.id.linearBeers);

            LinearLayout horiz = new LinearLayout(EventActivity.this);
            horiz.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout vert = new LinearLayout(EventActivity.this);
            vert.setOrientation(LinearLayout.VERTICAL);


//            assert beers != null;
//            horiz.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(MainActivity.this, BeerActivity.class);
//                    intent.putExtra("name", myname);
//                    intent.putExtra("style", mystyle);
//                    intent.putExtra("abv", myabv);
//                    intent.putExtra("price_per_glass" , mypriceperglass);
//                    intent.putExtra("price_per_growler", mypricepergrowl);
//                    startActivity(intent);
//                }
//
//            });

//            Beer type;
////            int num = (Integer)getIntent().getExtras().get("myid");
//
//            if (beer.getString("name").equals("Ellies Brown")){
//                type = Beer.ellies_brown[0];
//                image.setImageResource(type.getImageResourceID());
//            }

//            image.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(MainActivity.this, BeerActivity.class);
//                    startActivity(intent);
//                }
//
//            });
//            name.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(MainActivity.this, BeerActivity.class);
//                    startActivity(intent);
//                }
//
//            });
//            style.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(MainActivity.this, BeerActivity.class);
//                    startActivity(intent);
//                }
//
//            });
//            abv.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(MainActivity.this, BeerActivity.class);
//                    startActivity(intent);
//                }
//
//            });

            horiz.addView(image);

            vert.addView(title);
            vert.addView(description);
            vert.addView(location);
            vert.addView(starts_at);
            vert.addView(ticket_url);

            horiz.addView(vert);

//            beers.addView(vert);
            beers.addView(horiz);
        }
    }
}
