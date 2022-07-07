package pt.ipbeja.po2.chartracer.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Luís Gabriel da Cruz Silva
 * @number 19314
 * @version 06/07/2022
 */

public class WriteFileForTest {
    private ArrayList<Data> data;

    /**
     * Constructor of the class
     * @param data The ArrayList tho be accessed
     */
    public WriteFileForTest(ArrayList<Data> data) {
        this.data = data;
        try {
            this.writeFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes the file for the Test Method
     * @throws IOException
     */
    public void writeFile() throws IOException {
        FileWriter fileWriter = new FileWriter("./files/generated/orderedData.txt");

        for (int i = 0; i < 5; i++) {
            fileWriter.write(this.data.get(i).toString() + "\n");
        }

        int counter = 0;

        for (int i = 0; i < this.data.size(); i++) {
            if (counter < 5) {
                if (this.data.get(i).getDate().equals(this.data.get(data.size()-1).getDate())) {
                    fileWriter.write(this.data.get(i).toString() + "\n");
                    counter++;
                }
            } else {
                break;
            }
        }
        fileWriter.close();
    }
}
