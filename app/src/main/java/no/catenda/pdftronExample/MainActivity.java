package no.catenda.pdftronExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.net.Uri;
import com.pdftron.pdf.config.ViewerConfig;
import com.pdftron.pdf.controls.DocumentActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewerConfig config = new ViewerConfig.Builder().openUrlCachePath(this.getCacheDir().getAbsolutePath()).build();
        
        final Uri fileLink = Uri.parse("https://pdftron.s3.amazonaws.com/downloads/pdfref.pdf");
        final Uri uri = Uri.parse("file:///android_asset/test with^&!@£$%^&*()links.pdf"); // Doesn't open, no error
//        final Uri uri = Uri.parse("file:///android_asset/test_with_links.pdf"); // Works
        DocumentActivity.openDocument(this, uri, config);
    }
}