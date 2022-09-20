import java.io.IOException;

public class ServerFrom implements ServerState {

	@Override
	public ServerState execute(CountdownServerA connection) {
		try {
			String request = connection.receive();
			if (ServerProtocol.isValidFrom(request)) {
				Integer i = ServerProtocol.extractNumber(request);
				return new ServerStart(i);
			}
		} catch(IOException e) {
			return new ServerError("Failure in state ServerFrom");
		}
		
		return null;
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
