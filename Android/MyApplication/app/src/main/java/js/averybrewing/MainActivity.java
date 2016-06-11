package js.averybrewing;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends Activity {

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

                JSONArray jArray = new JSONArray(new JSONObject(result).getString("beers"));
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject beer = jArray.getJSONObject(i);
                    createBeer(beer);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // creates "beer" objects which consist of the image
        // and other info about a beer
        public void createBeer(JSONObject beer) throws JSONException, IOException {

            // Creates objects for beers
            ImageView image = new ImageView(MainActivity.this);

            final TextView name = new TextView(MainActivity.this);
            TextView style = new TextView(MainActivity.this);
            TextView abv = new TextView(MainActivity.this);


//            JSONObject imageDict = new JSONObject(beer.getString("label_image"));
//            String meow = (String) imageDict.getString("original");
//                URL url = new URL(meow);

//            URL url = new URL("http://techlovejump.com/wp-content/uploads/load-image-url-android.jpg");
//            InputStream is = url.openConnection().getInputStream();
//            Bitmap bitmap = BitmapFactory.decodeStream(is);


//                Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(meow).getContent());
//            image.setImageBitmap(bitmap);

////                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
////                Bitmap bmp = BitmapFactory.decodeStream((InputStream)new URL(meow).getContent());
//                Bitmap bmp = BitmapFactory.decodeStream(new java.net.URL(meow).openStream());
////                image.setImageBitmap(bmp);

                final String myname = beer.getString("name");
                final String mystyle = beer.getString("style");
                final String myabv = beer.getString("abv");
                final String mypriceperglass = beer.getString("price_per_glass");
                final String mypricepergrowl = beer.getString("price_per_growler");

                name.setText(beer.getString("name"));
                style.setText(beer.getString("style"));
                abv.setText("ABV: " + beer.getString("abv") + "%");


                name.setTextColor(Color.parseColor("#000000"));
                style.setTextColor(Color.parseColor("#000000"));
                abv.setTextColor(Color.parseColor("#000000"));

                //add formatting
                abv.setPadding(50, 0, 0, 150);
                name.setPadding(50, 0, 0, 0);
                style.setPadding(50, 0, 0, 0);


                //image formatting
                image.setMaxWidth(550);
                image.setMaxHeight(550);
                image.setPadding(0, 75, 0, 0);

                //text formatting
                name.setGravity(Gravity.CENTER_VERTICAL);
                style.setGravity(Gravity.CENTER_VERTICAL);
                abv.setGravity(Gravity.CENTER_VERTICAL);


                //status formatting
                name.setTextSize(20);


            // Creates views for each small animal
            LinearLayout beers = (LinearLayout) findViewById(R.id.linearBeers);

            LinearLayout horiz = new LinearLayout(MainActivity.this);
            horiz.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout vert = new LinearLayout(MainActivity.this);
            vert.setOrientation(LinearLayout.VERTICAL);


//            assert beers != null;
            horiz.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, BeerActivity.class);
                    intent.putExtra("name", myname);
                    intent.putExtra("style", mystyle);
                    intent.putExtra("abv", myabv);
                    intent.putExtra("price_per_glass" , mypriceperglass);
                    intent.putExtra("price_per_growler", mypricepergrowl);
                    startActivity(intent);
                }

            });

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
            vert.addView(name);
            vert.addView(style);
            vert.addView(abv);
            horiz.addView(vert);

//            beers.addView(vert);
            beers.addView(horiz);
        }
    }
}
