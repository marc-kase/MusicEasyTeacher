package kz.gereski.m.musiceasyteacher.gui.components;

import android.content.Context;
import android.widget.ImageView;

import kz.gereski.m.musiceasyteacher.core.music.Note;

public class BlackNoteKey extends ImageView {
    Note.Notes note;

    public BlackNoteKey(Context context) {
        super(context);
    }

    public BlackNoteKey(Context context, Note.Notes note) {
        super(context);
        this.note = note;
    }
}
