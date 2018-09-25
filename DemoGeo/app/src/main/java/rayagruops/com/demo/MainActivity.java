package rayagruops.com.demo;

/**
 * Created by Xaniar on 8/31/2018.
 */



import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends Activity implements View.OnClickListener {
    private ViewGroup mListView;

    //Comment to see if I can push to the repository

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mListView = (ViewGroup) findViewById(R.id.list);

//        addDemo("Clustering", ClusteringDemoActivity.class);
//        addDemo("Clustering: Custom Look", CustomMarkerClusteringDemoActivity.class);
//        addDemo("Clustering: 2K markers", BigClusteringDemoActivity.class);
        addDemo("PolyUtil.decode", PolyDecodeDemoActivity.class);
        addDemo("PolyUtil.simplify", PolySimplifyDemoActivity.class);
        addDemo("Icon Generator", IconGeneratorDemoActivity.class);
        addDemo("DistanceBetween ", DistanceDemoActivity.class);
//        addDemo("Generating tiles", TileProviderAndProjectionDemo.class);
//        addDemo("Heatmaps", HeatmapsDemoActivity.class);
//        addDemo("Heatmaps with Places API", HeatmapsPlacesDemoActivity.class);
        addDemo("GeoJSON Layer", GeoJsonDemoActivity.class);
        addDemo("KML Layer ", KmlDemoActivity.class);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void addDemo(String demoName, Class<? extends Activity> activityClass) {
        Button b = new Button(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);

//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        b.setLayoutParams(layoutParams);
        b.setText(demoName);
        b.setTag(activityClass);
        b.setBackground(getDrawable(R.drawable.rips));

        b.setTextColor(Color.WHITE);

        layoutParams.setMargins(10,10,10,10);


        b.setOnClickListener(this);
        mListView.addView(b);
    }

    @Override
    public void onClick(View view) {
        Class activityClass = (Class) view.getTag();
        startActivity(new Intent(this, activityClass));
    }
}