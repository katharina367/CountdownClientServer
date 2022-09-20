import java.io.IOException;

public class ClientStart implements ClientState {

	int i;
	
	public ClientStart(int i) {
		this.i = i;
	}
	
	@Override
	public ClientState execute(CountdownClientA connection) {
		try {
			String s = connection.receive();
			if (s == null) return new ClientError("Connection failed");
			if (!ClientProtocol.isValidStart(s, i)) return new ClientCount();
			else return new ClientCount();
		} catch(IOException e) {
			return new ClientError("Could not receive start message");
		}
	}

	@Override
	public boolean isEndingState() {
		return false;
	}

	@Override
	public boolean isErrorState() {
		return false;
	}

}
