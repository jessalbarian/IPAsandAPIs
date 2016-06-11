package js.averybrewing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BeerActivity extends Activity {

    public boolean onCreateOptionsMenu(Menu menu){
        //inflate menu to add items to the action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        //get the ID of the item on the action bar that was clicked
        switch (item.getItemId()){
            case R.id.events:
                //start event activity
                Intent intent = new Intent(BeerActivity.this, EventActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);

        LinearLayout beer = (LinearLayout) findViewById(R.id.linearBeers);
        String name = (String)getIntent().getExtras().get("name");
        String style = (String)getIntent().getExtras().get("style");
        String abv = (String)getIntent().getExtras().get("abv");
        String ppg = (String)getIntent().getExtras().get("price_per_glass");
        String ppgr = (String)getIntent().getExtras().get("price_per_growler");
//        Bitmap bmp = (Bitmap)getIntent().getExtras().get("image");

        TextView nameText = new TextView(BeerActivity.this);
        TextView styleText = new TextView(BeerActivity.this);
        TextView abvText = new TextView(BeerActivity.this);
        TextView glassText = new TextView(BeerActivity.this);
        TextView growlerText = new TextView(BeerActivity.this);
        ImageView image = new ImageView(BeerActivity.this);

        nameText.setText(name);
        styleText.setText(style);
        abvText.setText("ABV: " + abv + "%");
        glassText.setText("Glass Price: $" + ppg);
        growlerText.setText("Growler Price: $" + ppgr);
//        image.setImageBitmap(bmp);

        String imageName = name.toLowerCase().replace(' ', '_').replace("\'", "").replace(":", "").replace("!", "").replace("[","").replace("]", "").replace("-", "_");
        if(getResources().getIdentifier(imageName,"drawable","js.averybrewing")!=0){
            image.setImageResource(getResources().getIdentifier(imageName,"drawable","js.averybrewing"));
        }
        else {
            image.setImageResource(R.drawable.logo);
        }


        // formatting
        nameText.setGravity(Gravity.CENTER_HORIZONTAL);
        styleText.setGravity(Gravity.CENTER_HORIZONTAL);
        abvText.setGravity(Gravity.CENTER_HORIZONTAL);
        glassText.setGravity(Gravity.CENTER_HORIZONTAL);
        growlerText.setGravity(Gravity.CENTER_HORIZONTAL);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(700, 700);
        layoutParams.gravity=Gravity.CENTER;
        image.setLayoutParams(layoutParams);

        //status formatting
        nameText.setTextSize(25);
        styleText.setTextSize(20);
        abvText.setTextSize(20);
        glassText.setTextSize(20);
        growlerText.setTextSize(20);


        assert beer != null;
        beer.addView(image);
        beer.addView(nameText);
        beer.addView(styleText);
        beer.addView(abvText);
        beer.addView(glassText);
        beer.addView(growlerText);


    }
}
