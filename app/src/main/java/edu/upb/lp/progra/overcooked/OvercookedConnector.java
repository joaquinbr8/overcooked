package edu.upb.lp.progra.overcooked;
import android.widget.ImageView;

import edu.upb.lp.progra.adapterFiles.AndroidLibrary;
import edu.upb.lp.progra.adapterFiles.AppConnector;

public class OvercookedConnector implements AppConnector {
    private AndroidLibrary lib;
    private OvercookedGame game = new OvercookedGame(this);

    public OvercookedConnector(AndroidLibrary lib) {
        this.lib = lib;
    }

    @Override
    public void onButtonPressed(String name) {

    }

    @Override
    public void onCellPressed(int vertical, int horizontal) {
    }

    @Override
    public void initialiseInterface() {
        lib.configureScreen(17, 17, 1, 1, false, 0);
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                lib.setImageOnCell(i, j, "colors_brown");
            }
        }

        for (int h = 1; h < 5; h++) {
            lib.setImageOnCell(1, h, "colors_red");
            lib.setImageOnCell(3, h, "colors_red");
            lib.setImageOnCell(5, h, "colors_red");
        }
        lib.setImageOnCell(2, 1, "colors_red");
        lib.setImageOnCell(2, 4, "colors_red");
        lib.setImageOnCell(4, 1, "colors_red");
        lib.setImageOnCell(4, 4, "colors_red");

        lib.setImageOnCell(2, 2, "ficha_roja");
        lib.setImageOnCell(2, 3, "ficha_roja");
        lib.setImageOnCell(4, 2, "ficha_roja");
        lib.setImageOnCell(4, 3, "ficha_roja");


        for (int h = 12; h < 16; h++) {


            lib.setImageOnCell(1, h, "colors_purple");
            lib.setImageOnCell(3, h, "colors_purple");
            lib.setImageOnCell(5, h, "colors_purple");
        }
        lib.setImageOnCell(2, 12, "colors_purple");
        lib.setImageOnCell(2, 15, "colors_purple");
        lib.setImageOnCell(4, 12, "colors_purple");
        lib.setImageOnCell(4, 15, "colors_purple");

        lib.setImageOnCell(2, 13, "ficha_morada");
        lib.setImageOnCell(2, 14, "ficha_morada");
        lib.setImageOnCell(4, 13, "ficha_morada");
        lib.setImageOnCell(4, 14, "ficha_morada");


        for (int h = 12; h < 16; h++) {
            lib.setImageOnCell(11, h, "colors_green");
            lib.setImageOnCell(13, h, "colors_green");
            lib.setImageOnCell(15, h, "colors_green");
        }
        lib.setImageOnCell(12, 12, "colors_green");
        lib.setImageOnCell(12, 15, "colors_green");
        lib.setImageOnCell(14, 12, "colors_green");
        lib.setImageOnCell(14, 15, "colors_green");


        lib.setImageOnCell(12, 13, "ficha_verde");
        lib.setImageOnCell(12, 14, "ficha_verde");
        lib.setImageOnCell(14, 13, "ficha_verde");
        lib.setImageOnCell(14, 14, "ficha_verde");


        for (int h = 1; h < 5; h++) {

            lib.setImageOnCell(11, h, "colors_yellow");
            lib.setImageOnCell(13, h, "colors_yellow");
            lib.setImageOnCell(15, h, "colors_yellow");
        }
        lib.setImageOnCell(12, 1, "colors_yellow");
        lib.setImageOnCell(12, 4, "colors_yellow");
        lib.setImageOnCell(14, 1, "colors_yellow");
        lib.setImageOnCell(14, 4, "colors_yellow");


        lib.setImageOnCell(12, 2, "ficha_amarilla");
        lib.setImageOnCell(12, 3, "ficha_amarilla");
        lib.setImageOnCell(14, 2, "ficha_amarilla");
        lib.setImageOnCell(14, 3, "ficha_amarilla");

        for (int h = 1; h < 7; h++) {
            lib.setImageOnCell(7, h, "colors_grey");
            lib.setImageOnCell(9, h, "colors_grey");

        }
        lib.setImageOnCell(7, 7, "colors_grey");
        lib.setImageOnCell(9, 7, "colors_grey");
        lib.setImageOnCell(8, 1, "colors_grey");
        lib.setImageOnCell(8, 7, "colors_black");
        lib.setImageOnCell(8, 8, "dado_1");

        for (int h = 2; h < 7; h++) {
            lib.setImageOnCell(8, h, "colors_grey");
        }

        for (int h = 10; h < 16; h++) {
            lib.setImageOnCell(7, h, "colors_grey");
            lib.setImageOnCell(9, h, "colors_grey");
        }
        lib.setImageOnCell(8, 15, "colors_grey");
        lib.setImageOnCell(8, 9, "colors_black");
        lib.setImageOnCell(7, 9, "colors_grey");
        lib.setImageOnCell(9, 9, "colors_grey");

        for (int h = 10; h < 15; h++) {
            lib.setImageOnCell(8, h, "colors_grey");
        }

        for (int v = 1; v < 7; v++) {
            lib.setImageOnCell(v, 7, "colors_grey");
            lib.setImageOnCell(v, 9, "colors_grey");
        }
        lib.setImageOnCell(1, 8, "colors_grey");
        for (int v = 2; v < 7; v++) {
            lib.setImageOnCell(v, 8, "colors_grey");
        }
        for (int v = 10; v < 16; v++) {
            lib.setImageOnCell(v, 7, "colors_grey");
            lib.setImageOnCell(v, 9, "colors_grey");
        }
        lib.setImageOnCell(15, 8, "colors_grey");

        for (int v = 10; v < 15; v++) {
            lib.setImageOnCell(v, 8, "colors_grey");
        }
        lib.setImageOnCell(7, 8, "colors_black");
        lib.setImageOnCell(9, 8, "colors_black");

    }
}


