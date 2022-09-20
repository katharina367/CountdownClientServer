import java.io.IOException;

public class ClientBye implements ClientState {

	@Override
	public ClientState execute(CountdownClientA connection) {
		try {
			String a = connection.receive();
			if(!ClientProtocol.isValidBye(a)) return new ClientError("Invalid bye");
			else return new ClientEnd();
		} catch (IOException e) {
			return new ClientError("Message not received");
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
