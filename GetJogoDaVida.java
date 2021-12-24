import java.net.DatagramPacket;
import java.net.DatagramSocket;
/**
 *
 * @author Thiago Emanuel Silva Antunes Lopes
 */
public class GetJogoDaVida{
    public static void main(String[] args) throws Exception {
        
        DatagramPacket datagramPacket;
        
        DatagramSocket socket;
        int port = 60000;
        socket = new DatagramSocket(port);
        
        byte[] bufferBytes = new byte[1024];
        String inString;
        
        while(true) {
            System.out.println("________________________________");
            datagramPacket = new DatagramPacket(bufferBytes, bufferBytes.length);
            System.out.println("Esperando recebimento de datagrama.");
            socket.receive(datagramPacket);
            //execucao travada enquanto espera a chegada do datagrama pelo port
            System.out.println("Recebemos um datagrama: ");
            inString = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            //0 é o offset
            System.out.print(inString);
            System.out.println("________________________________");
        }
        
    }
    
}
