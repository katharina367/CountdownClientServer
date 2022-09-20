import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CountdownServerA implements Runnable {
	private final int PORT = 4444;
	private ServerSocket server;
	private Socket client;
	private PrintWriter out;
	private BufferedReader in;
	private Thread talk;
	private ServerState zustand;
	
	public CountdownServerA() {
		init();
	}
	
	public static void main (String [] args) {
		new CountdownServerA();
	}
	
	public void send(String s) {
		out.println(s);
		System.out.println("Server ->" + s);
	}
	
	public String receive() throws IOException {
		String request = in.readLine();
		System.out.println("Server <- " + request);
		return request;
	}
	
	private void start() {
		talk = new Thread (this, "talk");
		talk.start();
	}
	
	private void init() {
		try {
			this.server = new ServerSocket(PORT);
			System.out.println("Start succeeded.");
			start();
		} catch(IOException e) {
			System.out.println("Start failed.");
		}
		
	}
	
	private void finish() {
		try {
			this.server.close(); // NullPointerException
			System.out.println("Server is closed.");
		} catch (IOException e) {
			System.out.println("Shutting down server didn´t work.");
		}
		
	}
	
	@Override
	public void run() {
		while(!this.server.isClosed()) {
			try {
				client = server.accept();
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = new PrintWriter(client.getOutputStream(), true);
				zustand = new ServerWelcome();
				while(!zustand.isEndingState() && !zustand.isErrorState()) {
					zustand = zustand.execute(this);
					
				}
				if(zustand.isErrorState()) {
					System.err.println(((ServerError)zustand).getMsg());
				}
			} catch (IOException e) {
				System.out.println("Connection establishment failed.");
			} finally {
				finish();
			}
			
		}
		
	}

}

