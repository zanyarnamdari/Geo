//package rayagruops.com.demo;
//
///**
// * Created by Xaniar on 8/31/2018.
// */
//

//
//import android.util.DisplayMetrics;
//import android.widget.Toast;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.maps.android.clustering.ClusterManager;
//import com.google.maps.android.clustering.algo.NonHierarchicalViewBasedAlgorithm;
//
//import org.json.JSONException;
//
//import java.io.InputStream;
//import java.util.List;
//
//import rayagruops.com.demo.model.MyItem;
//
//public class VisibleClusteringDemoActivity extends BaseDemoActivity {
//    private ClusterManager<MyItem> mClusterManager;
//
//    @Override
//    protected void startDemo() {
//        DisplayMetrics metrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(metrics);
//
//        getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.503186, -0.126446), 10));
//
//        mClusterManager = new ClusterManager<MyItem>(this, getMap());
//        mClusterManager.setAlgorithm(new NonHierarchicalViewBasedAlgorithm<MyItem>(
//                metrics.widthPixels, metrics.heightPixels));
//
//        getMap().setOnCameraIdleListener(mClusterManager);
//
//        try {
//            readItems();
//        } catch (JSONException e) {
//            Toast.makeText(this, "Problem reading list of markers.", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    private void readItems() throws JSONException {
//        InputStream inputStream = getResources().openRawResource(R.raw.radar_search);
//        List<MyItem> items = new MyItemReader().read(inputStream);
//        for (int i = 0; i < 100; i++) {
//            double offset = i / 60d;
//            for (MyItem item : items) {
//                LatLng position = item.getPosition();
//                double lat = position.latitude + offset;
//                double lng = position.longitude + offset;
//                MyItem offsetItem = new MyItem(lat, lng);
//                mClusterManager.addItem(offsetItem);
//            }
//        }
//    }
//}