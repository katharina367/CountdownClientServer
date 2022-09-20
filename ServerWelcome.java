
public class ServerWelcome implements ServerState {
	public ServerState execute(CountdownServerA connection) {
		connection.send(ServerProtocol.getWelcome());
		return new ServerFrom();
	}

	public boolean isEndingState() {
		return false;
	}

	public boolean isErrorState() {
		return false;
	}

}
