package pt.ipbeja.po2.chartracer.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteDataFile {
    private ArrayList<Data> data;

    public WriteDataFile(ArrayList<Data> data) {
        this.data = data;
        try {
            this.writeFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFile() throws IOException {
        FileWriter fileWriter = new FileWriter("./files/orderedData.txt");

        for (int i = 0; i < 5; i++) {
            fileWriter.write(this.data.get(i).toString() + "\n");
        }

        int counter = 0;

        for (int i = 0; i < this.data.size(); i++)
        {
            if (counter < 5)
            {
                if (this.data.get(i).year.equals(this.data.get(data.size()-1).year)){
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
