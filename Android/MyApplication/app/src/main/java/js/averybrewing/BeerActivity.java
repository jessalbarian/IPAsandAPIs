package js.averybrewing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BeerActivity extends Activity {


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

        TextView nameText = new TextView(BeerActivity.this);
        TextView styleText = new TextView(BeerActivity.this);
        TextView abvText = new TextView(BeerActivity.this);
        TextView glassText = new TextView(BeerActivity.this);
        TextView growlerText = new TextView(BeerActivity.this);

        nameText.setText(name);
        styleText.setText(style);
        abvText.setText("ABV: " + abv + "%");
        glassText.setText("Glass Price: $" + ppg);
        growlerText.setText("Growler Price: $" + ppgr);


        // formatting
        nameText.setGravity(Gravity.CENTER_HORIZONTAL);
        styleText.setGravity(Gravity.CENTER_HORIZONTAL);
        abvText.setGravity(Gravity.CENTER_HORIZONTAL);
        glassText.setGravity(Gravity.CENTER_HORIZONTAL);
        growlerText.setGravity(Gravity.CENTER_HORIZONTAL);


        //status formatting
        nameText.setTextSize(25);
        styleText.setTextSize(20);
        abvText.setTextSize(20);
        glassText.setTextSize(20);
        growlerText.setTextSize(20);


        assert beer != null;
        beer.addView(nameText);
        beer.addView(styleText);
        beer.addView(abvText);
        beer.addView(glassText);
        beer.addView(growlerText);


    }
}
