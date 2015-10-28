package kz.gereski.m.musiceasyteacher.gui.windows;

import android.app.Activity;
import android.os.Bundle;

import kz.gereski.m.musiceasyteacher.R;
import kz.gereski.m.musiceasyteacher.gui.components.NoteKey;

public class MenuPageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        NoteKey k = (NoteKey) findViewById(R.id.s4mi);
//        k.setNote(Note.Notes.b3lah);
    }

}
