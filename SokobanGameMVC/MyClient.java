import java.io.*;
import java.net.Socket;

public class MyClient extends Thread {
	
	private Socket socket;

	public MyClient(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		System.out.println("socket = " + socket);
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
			BufferedReader in = new BufferedReader(inputStreamReader);
			String infoFromClient = in.readLine();
			System.out.println("Message: " + infoFromClient);
			
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(outputStream);
			switch (infoFromClient) {
				case "Level_7":
					FirstServerLevel firstServerLevel = new FirstServerLevel();
					out.writeObject(firstServerLevel);
					break;
				case "Level_8":
					ServerLevel serverLevel = new ServerLevel();
					out.writeObject(serverLevel);
					break;
				case "Level_9":
					LastServerLevel lastServerLevel = new LastServerLevel();
					out.writeObject(lastServerLevel);
					break;
			}


			socket.close();

		} catch(IOException ioe) {
			// To log here
			System.out.println("Error " + ioe);
		}
	}

}