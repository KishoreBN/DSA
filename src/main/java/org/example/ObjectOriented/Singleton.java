package org.example.ObjectOriented;

/**
 * Singleton classes will have only one instance of it at any point of time.
 * Below is Lazy initialization of Singleton.
 */
class DBConnection {
    private static DBConnection instance;
    private DBConnection(){};

    public static DBConnection getInstance(){
        if(instance == null){
            instance = new DBConnection();
        }
        return instance;
    }
}

class Singleton{
    public static void main(String[] args) {
        DBConnection con1 = DBConnection.getInstance();
        System.out.println(con1);
        DBConnection con2 = DBConnection.getInstance();
        System.out.println(con2);
    }
}
