package pt.ipbeja.po2.chartracer.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.control.*;
import pt.ipbeja.po2.chartracer.model.ChartRacer;
import pt.ipbeja.po2.chartracer.model.View;
import java.io.File;
import java.io.IOException;

/**
 * @author Luís Gabriel da Cruz Silva
 * @number 19314
 * @version 06/07/2022
 */

public class DataMenu extends MenuBar {
    private ChartRacer chartRacer;
    private BarChartBoard barChartBoard;
    private final String[] DATA_MENU_ITEMS = new String[]{"Data Files", "Generate File", "Exit"};
    private final String[] DATA_FILES_MENU_ITEM_TEXT = new String[]{"baby-names", "brands", "cities", "cities-usa", "countries", "endgame", "football"};
    private Menu menu;
    private MenuItem[] menuItems;
    private Menu dataFilesMenu;
    private MenuItem[] dataFilesMenuItems;
    private MenuItem generateDataItem;

    public DataMenu(ChartRacer chartRacer){
        this.chartRacer = chartRacer;
        this.generateDataItem = new MenuItem("Generate Data");
        this.dataFilesMenu = new Menu(DATA_MENU_ITEMS[0]);
        this.dataFilesMenuItems = new MenuItem[DATA_FILES_MENU_ITEM_TEXT.length];
        this.menuItems = new MenuItem[DATA_MENU_ITEMS.length];
        this.menu = new Menu("Data");
        this.setMenuItems();
        this.setDatasetsMenu();
        this.exitHandler();
        this.generateDataItemHandler();
        this.getMenus().add(menu);
    }

    private void setDatasetsMenu(){

        for (int i = 0; i < dataFilesMenuItems.length; i++){
            dataFilesMenuItems[i] = new MenuItem(DATA_FILES_MENU_ITEM_TEXT[i] + "");

            dataFilesMenu.getItems().add(dataFilesMenuItems[i]);
        }
    }

    private void generateDataItemHandler(){
        this.menuItems[1].setOnAction(e -> {
            try {
                this.chartRacer.generateDataFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void setMenuItems(){
        menuItems[0] = this.dataFilesMenu;
        menuItems[1] = this.generateDataItem;
        menuItems[2] = new MenuItem("Exit");
        this.menu.getItems().addAll(menuItems);
    }

    private void exitHandler(){
        this.menuItems[2].setOnAction(e -> {
            System.exit(0);
        });
    }

}

