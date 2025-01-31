package fileio;
import entities.Admin;

import java.io.*;

public class AdminFileHandler {
    private static final String ADMIN_FILE = "resources/Admin.txt";

    public static Admin[] getAllAdmins() {
        int size = countLinesInFile();
        Admin[] admins = new Admin[size];
        try (BufferedReader reader = new BufferedReader(new FileReader(ADMIN_FILE))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                admins[index++] = Admin.fromFileFormat(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading Admin file: " + e.getMessage());
        }
        return admins;
    }

    public static Admin findAdminByUsername(String username) {
        Admin[] admins = getAllAdmins();
        for (Admin admin : admins) {
            if (admin != null && admin.getUsername().equals(username)) {
                return admin;
            }
        }
        return null;
    }

    private static int countLinesInFile() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(ADMIN_FILE))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error counting lines in Admin file: " + e.getMessage());
        }
        return count;
    }
}



