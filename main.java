
public class Main{
    public static void main(String[] args) {

        Attribute [] barang = new Attribute[]{
            new SmartTv("[ID: TV-01]", "[TV Living Room]", 120, 5, 20, "Menyala")
        };

        for(Attribute h : barang){
            h.printdata();
        }
    }
}
interface Connectable{
    void Koneksi();
}

interface Switchable{
    void gontaganti();
}

interface Lockable{
    void lock();
}


abstract class Attribute{
    String id;
    String nama;
    double daya;
    String status;

    enum status {
        Menyala , Mati , Terbuka , Terkunci
    }

    abstract String jenisBarang();

    abstract String turnOn();
    abstract String turnOff();
    
    public void printdata(){
        System.out.print(jenisBarang());
        System.out.println(getNama() + getID() + "- Daya: " +getDaya() + "| Status: " + getDeviceDetail() );

    }

    String getDeviceDetail(){
        return status;
    }

    void setID(String id){
        this.id = id;
    }
    String getID(){
        return id;
    }
    void setNama(String Nama){
        this.nama = Nama;
    }
    String getNama(){
        return nama;
    }
    void setDaya(double daya){
        this.daya = daya;
    }
    double getDaya(){
        return daya;
    }
    public Attribute(String id , String Nama , double daya , String status){
        this.id = id;
        this.nama = Nama;
        this.daya = daya;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class SmartTv extends Attribute implements Connectable{
    int channel;
    int volume;


    public SmartTv(String id , String nama , double daya , int channel , int volume, String Status){
        super(id, nama, daya , Status);
        this.channel = channel;
        this.volume = volume;
    }
    public void Koneksi(){
        System.out.print("WIFI");
    }
    @Override
    String turnOn(){
        return "Menyala";
    }
    @Override
    String turnOff(){
        return "Mati";
    }
    @Override
    String jenisBarang(){
        return "Smart TV";
    }

    public void printData(){
        super.printdata();
        System.out.print("| Koneksi :");
        Koneksi();
        System.out.print("| Channel " + channel + "| Volume: "+volume);

    }

}
class SmartSpeaker extends Attribute implements  Connectable{
    int volume;

    
    public SmartSpeaker(String id , String nama , double daya , int channel , int volume, String Status){
        super(id, nama, daya , Status);
        this.volume = volume;
    }
    public void Koneksi(){
        System.out.print("BLUETOOTH");
    }
    @Override
    String turnOn(){
        return "Menyala";
    }
    @Override
    String turnOff(){
        return "Mati";
    }
    @Override
    String jenisBarang(){
        return "Smart Speaker";
    }
    
    public void printData(){
        super.printdata();
        System.out.print("| Koneksi :");
        Koneksi();
        System.out.print("| Volume: "+volume);

    }
}
class SmartDoorLock extends Attribute implements Lockable{
    int pin;
    
    enum status{
        Terkunci , Terbuka
    }

    public SmartDoorLock(String id , String nama , double daya, int pin,String Status){
        super(id, nama, daya,Status);
        this.pin = pin;
    }
    public void lock(){
        System.out.print("Terkunci");
    }
    @Override
    String turnOn(){
        return "Menyala";
    }
    @Override
    String turnOff(){
        return "Mati";
    }
    
    @Override
    String jenisBarang(){
        return "Smart TV";
    }
}
