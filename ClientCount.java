import java.io.IOException;

public class ClientCount implements ClientState {

	@Override
	public ClientState execute(CountdownClientA connection) {
		try {
			String a = connection.receive();
			if (!ClientProtocol.isNumber(a)) return new ClientError ("No number"); 
			int b = Integer.valueOf(a);
			if (b > 0) {
				return new ClientCount();
			} if (b == 0) {
				return new ClientBye();
			} else {
				return new ClientError("Invalid Number");
			}
		} catch (IOException e) {
			return new ClientError("Could not receive starting number");
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
