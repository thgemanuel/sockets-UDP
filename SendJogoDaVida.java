import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
/**
 *
 * @author Thiago Emanuel Silva Antunes Lopes
 */
public class SendJogoDaVida {
    public static void main(String[] args) throws Exception {
        byte[] bufferBytes = new byte[1024];
        String indice;
        Scanner scanner = new Scanner(System.in);
        
        DatagramSocket socket = new DatagramSocket();
        
        int port = 60000;
        InetAddress address = InetAddress.getByName("localhost");
        
        DatagramPacket datagramPacket;

        int [][] grade = new int [8][8]; //definindo a grade original
        
        for(int i=0;i<8;i++) 
            for(int j=0;j<8;j++)
                grade[i][j]=0; 
                //iniciando a grade com celulas mortas   
                
            
        while(true){
            System.out.println("Escreva as posicoes vivas: (ao final digite 'fim')");
            indice = scanner.nextLine();
            //indices da posicao viva
            

            if(indice.equals("fim"))
            break;
           
            System.out.println("Indice: " + indice);
            
            String[] item = indice.split(" ");
            
            int linha = Integer.parseInt(item[0]);
            int coluna = Integer.parseInt(item[1]);

            //setando as posicoes vivas
            grade[linha][coluna]=1;
            
        }
        indice="";
        //grade para atualizacao
        int [][] gradeatualizada = new int [8][8]; 

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                //iniciando a gradeagradeatualizada
                gradeatualizada[i][j]=grade[i][j];  
                indice =indice + grade[i][j]+ " ";   
            }
           indice =indice + "\n";
        }

        bufferBytes =indice.getBytes();
        datagramPacket = new DatagramPacket(bufferBytes, bufferBytes.length, address, port);

        socket.send(datagramPacket);

        int reviver;
        while(true){
            reviver=0;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){                    
                    reviver=0;
                    if(grade[i][j]==0 || grade[i][j]==1)
                    {
                        //ver se ele ta na ponta esquerda
                        if((i-1) >= 0)
                        {
                            if((j-1)>=0 && grade[i-1][j-1]==1)
                                reviver++;
                            if(grade[i-1][j]==1)
                                reviver++;
                            if((j+1)<8&&grade[i-1][j+1]==1)
                                reviver++;
                        }
                        //ver se ele ta na ponta direita
                        if((i+1)<8)
                        {
                            if((j-1)>=0&&grade[i+1][j-1]==1)
                                reviver++;
                            if(grade[i+1][j]==1)
                                reviver++;
                            if((j+1)<8&&grade[i+1][j+1]==1)
                                reviver++;
                        }
                        if((j-1)>=0&&grade[i][j-1]==1)
                            reviver++;

                        if((j+1)<8&&grade[i][j+1]==1)
                            reviver++;
                            
                        if(grade[i][j]==0)
                        { 
                            //Se uma célula morta tem três vizinhos ela se torna viva.
                            if(reviver==3)
                            {
                               gradeatualizada[i][j]=1;
                                reviver=0;
                            }
                        }
                            
                        if(grade[i][j]==1)
                        {
                            //Se uma célula viva tem menos de dois vizinhos ela morre de solidão. 
                            if(reviver<2)
                            {
                               gradeatualizada[i][j]=0;
                                reviver=0;
                            }
                        
                            //Se uma célula viva tem mais de três vizinhos ela morre por superpopulação.    
                            if(reviver>3){
                               gradeatualizada[i][j]=0;
                                reviver=0;
                            }
                        }    
                    }
                    reviver=0;
                }
            }
            indice = "";
            for(int i=0;i<8;i++)
            {
                indice =indice + "|";
                for(int j=0;j<8;j++)
                { 
                    //atualizando a nova grade
                    grade[i][j] = gradeatualizada[i][j];
                    indice = indice+grade[i][j]+" ";   
                }
               
                indice =indice + "| \n";
            }
            
            bufferBytes =indice.getBytes();
            datagramPacket = new DatagramPacket(bufferBytes, bufferBytes.length, address, port);
            //enviar datagrama
            socket.send(datagramPacket);
            Thread.sleep(3000);
        }
    }    
}