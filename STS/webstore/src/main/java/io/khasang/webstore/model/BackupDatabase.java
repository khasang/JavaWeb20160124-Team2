package io.khasang.webstore.model;

public class BackupDatabase {
    static String result;

    public String backupResultOut() {
        BackupDatabase db = new BackupDatabase();
        db.backupDatabase();
        return result;
    }

    public void backupDatabase() {
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("mysqldump -u root -proot webstore -r  \"C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Uploads\\backup.sql\"");
            result = "success";
        }
        catch (Exception e) {
            result = "Error:" + e;
        }
    }
}


