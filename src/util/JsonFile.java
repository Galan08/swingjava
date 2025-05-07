/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import dto.Persona;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SCIS2-29
 */
public class JsonFile {

    public boolean crearCarpeta() {
        File folder = new File("db");
        folder.mkdir();

        File file = new File("db/personas.json");
        if (file.exists()) {
            return true;
        }

        try {
            file.createNewFile();
            BufferedWriter bv = new BufferedWriter(new FileWriter("db/persona.json"));
            bv.write("[]");
            bv.close();

        } catch (Exception ex) {
            Logger.getLogger(JsonFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean guardarDatos(Persona persona) {

        try {
            RandomAccessFile raf = new RandomAccessFile("db/persona.json", "rw");
            long length = raf.length();
            raf.seek(length - 1);
            if (length > 2) {
                raf.writeBytes(",");
            }
            
            raf.writeBytes("]");
            return true;
            

        } catch (Exception e) {
            return false;
        }
    }

}
