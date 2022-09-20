import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CountdownClientA implements Runnable {

	private final int PORT = 4444;
	private final String IP = "localhost";
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	private Thread talk;
	private ClientState zustand;
	public Integer count;
	
	public static void main (String [] args) {
		new CountdownClientA(5);
	}
	
	public CountdownClientA(Integer count) {
		this.count = count;
		init();
	}
	
	public void send(String s) {
		out.println(s);
		System.out.println("Client -> " + s);
	}
	
	public String receive() throws IOException {
		String request = in.readLine();
		System.out.println("Client <- " + request);
		return request;
	}
	
	private void start() {
		talk = new Thread (this, "talk");
		talk.start();
	}
	
	private void finish() {
		try {
			this.socket.close();
			System.out.println("Server is closed.");
		} catch (IOException e) {
			System.out.println("Shutting down server didn´t work.");
		}
	}
	
	private void init() {
		try {
			this.socket = new Socket(IP, PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			zustand = new ClientWelcome(this.count);
			start();
		} catch(IOException e) {
			zustand = new ClientError("Connection establishment failed");
		}
	}
	
	@Override
	public void run() {
		while(!zustand.isEndingState() && !zustand.isErrorState()) {
			zustand = zustand.execute(this);
		}
		if(zustand.isErrorState()) {
			System.out.println(((ClientError)zustand).getErrMsg());
		}
		finish();	
	}
}
