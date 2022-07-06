package pt.ipbeja.po2.chartracer.gui;

import javafx.scene.control.*;
import pt.ipbeja.po2.chartracer.model.ChartRacer;
import java.io.IOException;

/**
 * @author Luís Gabriel da Cruz Silva
 * @number 19314
 * @version 06/07/2022
 */

public class DataMenu extends MenuBar {
    private ChartRacer chartRacer;
    private final String[] DATA_MENU_ITEMS = new String[]{"Start", "Generate File", "Exit"};
    private Menu menu;
    private MenuItem[] menuItems;
    private MenuItem startOption;
    private CheckMenuItem generateDataItem;

    /**
     * Creates the DataMenu
     * @param chartRacer The model of the program
     */
    public DataMenu(ChartRacer chartRacer){
        this.chartRacer = chartRacer;
        this.menu = new Menu("Data");
        this.startOption = new MenuItem("Start");
        this.generateDataItem = new CheckMenuItem("Generate Data");
        this.menuItems = new MenuItem[DATA_MENU_ITEMS.length];
        this.setMenuItems();
        this.exitHandler();
        this.startAnimationHandler();
        this.generateDataItemHandler();
        this.getMenus().add(menu);
    }

    /**
     * Handler to generate the file based on the check menu item
     */
    private void generateDataItemHandler(){
        this.menuItems[1].setOnAction(e -> {
            try {
                this.chartRacer.generateDataFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    /**
     * Handler to start the animation of the graphic
     */
    private void startAnimationHandler(){
        this.menuItems[0].setOnAction(e->{
            if (this.generateDataItem.isSelected()){
                try {
                    this.chartRacer.generateDataFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            this.chartRacer.executeNewThread();
            this.menuItems[0].setDisable(true);
        });
    }

    /**
     * Creates the menu
     */
    private void setMenuItems(){
        menuItems[0] = this.startOption;
        menuItems[1] = this.generateDataItem;
        menuItems[2] = new MenuItem("Exit");
        this.menu.getItems().addAll(menuItems);
    }

    /**
     * Handler to exit the program
     */
    private void exitHandler(){
        this.menuItems[2].setOnAction(e -> {
            System.exit(0);
        });
    }

}

