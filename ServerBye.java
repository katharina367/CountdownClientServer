
public class ServerBye implements ServerState {

	@Override
	public ServerState execute(CountdownServerA connection) {
		connection.send(ServerProtocol.getBye());		
		return new ServerEnd();
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
