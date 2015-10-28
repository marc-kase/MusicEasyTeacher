package kz.gereski.m.musiceasyteacher.core.music;


import android.content.Context;

public class Note {
    public static enum Notes {
        blank("0", ""),
        b3lah("La#",""), b3si("Si",""),
        s4do("Do",""), s4doh("Do#",""), s4re("Re",""), s4reh("Re#",""),s4mi("Mi",""), s4fa("Fa",""), s4fah("Fa#",""), s4so("So",""), s4soh("So#",""), s4la("La",""), s4lah("La#",""), s4si("Si",""),
        s5do("Do",""), s5doh("Do#",""), s5re("Re",""), s5reh("Re#",""),s5mi("Mi",""), s5fa("Fa",""), s5fah("Fa#",""), s5so("So",""), s5soh("So#",""), s5la("La",""), s5lah("La#",""), s5si("Si","");

        public String classic;
        public String american;

        Notes(String classic, String american) {
            this.classic = classic;
            this.american = american;
        }

        @Override
        public String toString() {
            return classic + "\n" + american;
        }

        public int getSoundLink(Context context) {
            int soundId = context.getResources().getIdentifier(super.name(), "raw", context.getPackageName());
            return soundId;
        }
    }
}
