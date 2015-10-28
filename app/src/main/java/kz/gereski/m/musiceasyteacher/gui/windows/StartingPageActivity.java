package kz.gereski.m.musiceasyteacher.gui.windows;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import kz.gereski.m.musiceasyteacher.R;

public class StartingPageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page);

        ImageView iv = (ImageView)findViewById(R.id.startingImage);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPage();
            }
        });
    }

    private void nextPage() {
        Intent intent = new Intent(this, MenuPageActivity.class);
        startActivity(intent);
    }
}
