interface Database{
    void connect();
}
class MySQLDatatbase implements Database{
    public void connect(){
    }
}
class PostSQLDatabase implements Database{
    public void connect(){}
}
class OrderService{
    Database db;
    OrderService(Database db) {
        this.db=db;
    }
    
}