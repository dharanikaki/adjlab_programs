
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class DSender{
	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket();
		String str = "hello world";
		InetAddress ia = InetAddress.getByName("localhost");
		System.out.println(ia);//.toString());
		DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ia, 300);
		ds.send(dp);
		ds.close();
	}
} 