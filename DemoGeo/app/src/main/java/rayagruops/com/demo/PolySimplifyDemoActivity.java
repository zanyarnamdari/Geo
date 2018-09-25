package rayagruops.com.demo;

/**
 * Created by Xaniar on 8/31/2018.
 */



import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class PolySimplifyDemoActivity extends BaseDemoActivity {

    private final static String LINE = "elfjD~a}uNOnFN~Em@fJv@tEMhGDjDe@hG^nF??@lA?n@IvAC`Ay@A{@DwCA{CF_EC{CEi@PBTFDJBJ?V?n@?D@?A@?@?F?F?LAf@?n@@`@@T@~@FpA?fA?p@?r@?vAH`@OR@^ETFJCLD?JA^?J?P?fAC`B@d@?b@A\\@`@Ad@@\\?`@?f@?V?H?DD@DDBBDBD?D?B?B@B@@@B@B@B@D?D?JAF@H@FCLADBDBDCFAN?b@Af@@x@@";
    private final static String OVAL_POLYGON = "}wgjDxw_vNuAd@}AN{A]w@_Au@kAUaA?{@Ke@@_@C]D[FULWFOLSNMTOVOXO\\I\\CX?VJXJTDTNXTVVLVJ`@FXA\\AVLZBTATBZ@ZAT?\\?VFT@XGZAP";
    private final static int ALPHA_ADJUSTMENT = 0x77000000;

    @Override
    protected void startDemo() {
        GoogleMap mMap = getMap();

        // Original line
        List<LatLng> line = PolyUtil.decode(LINE);
        mMap.addPolyline(new PolylineOptions()
                .addAll(line)
                .color(Color.BLACK));

        getMap().animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.315352, 46.992803), 12.0f), 4000, null);

        List<LatLng> simplifiedLine;

        /*
         * Simplified lines - increasing the tolerance will result in fewer points in the simplified
         * line
         */
        double tolerance = 5; // meters
        simplifiedLine = PolyUtil.simplify(line, tolerance);
        mMap.addPolyline(new PolylineOptions()
                .addAll(simplifiedLine)
                .color(Color.RED - ALPHA_ADJUSTMENT));

        tolerance = 20; // meters
        simplifiedLine = PolyUtil.simplify(line, tolerance);
        mMap.addPolyline(new PolylineOptions()
                .addAll(simplifiedLine)
                .color(Color.GREEN - ALPHA_ADJUSTMENT));

        tolerance = 50; // meters
        simplifiedLine = PolyUtil.simplify(line, tolerance);
        mMap.addPolyline(new PolylineOptions()
                .addAll(simplifiedLine)
                .color(Color.MAGENTA - ALPHA_ADJUSTMENT));

        tolerance = 500; // meters
        simplifiedLine = PolyUtil.simplify(line, tolerance);
        mMap.addPolyline(new PolylineOptions()
                .addAll(simplifiedLine)
                .color(Color.YELLOW - ALPHA_ADJUSTMENT));

        tolerance = 1000; // meters
        simplifiedLine = PolyUtil.simplify(line, tolerance);
        mMap.addPolyline(new PolylineOptions()
                .addAll(simplifiedLine)
                .color(Color.BLUE - ALPHA_ADJUSTMENT));


        // Triangle polygon - the polygon should be closed
        ArrayList<LatLng> triangle = new ArrayList<>();
        triangle.add(new LatLng(35.315352, 46.992803));  // Should match last point
        triangle.add(new LatLng(35.316420, 46.997524));
        triangle.add(new LatLng(35.313302, 47.005850));
        triangle.add(new LatLng(35.308154, 47.004261));
        triangle.add(new LatLng(35.307682, 46.998875));
        triangle.add(new LatLng(35.307542, 46.989885));
        triangle.add(new LatLng(35.315352, 46.992803));  // Should match first point

        mMap.addPolygon(new PolygonOptions()
                .addAll(triangle)
                .fillColor(Color.BLUE - ALPHA_ADJUSTMENT)
                .strokeColor(Color.BLUE)
                .strokeWidth(5));

        // Simplified triangle polygon
        tolerance = 88; // meters
        List simplifiedTriangle = PolyUtil.simplify(triangle, tolerance);
        mMap.addPolygon(new PolygonOptions()
                .addAll(simplifiedTriangle)
                .fillColor(Color.YELLOW - ALPHA_ADJUSTMENT)
                .strokeColor(Color.YELLOW)
                .strokeWidth(5));

        // Oval polygon - the polygon should be closed
        List<LatLng> oval = PolyUtil.decode(OVAL_POLYGON);
        mMap.addPolygon(new PolygonOptions()
                .addAll(oval)
                .fillColor(Color.BLUE - ALPHA_ADJUSTMENT)
                .strokeColor(Color.BLUE)
                .strokeWidth(5));

        // Simplified oval polygon
        tolerance = 10; // meters
        List simplifiedOval= PolyUtil.simplify(oval, tolerance);
        mMap.addPolygon(new PolygonOptions()
                .addAll(simplifiedOval)
                .fillColor(Color.YELLOW - ALPHA_ADJUSTMENT)
                .strokeColor(Color.YELLOW)
                .strokeWidth(5));
    }
}