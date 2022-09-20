
public class ServerStart implements ServerState {

	Integer c;
	
	public ServerStart(Integer c) {
		this.c = c;
	}
	@Override
	public ServerState execute(CountdownServerA connection) {
		int count = this.c.intValue();
		String msg = ServerProtocol.getStart(count);
		connection.send(msg);
		return new ServerCount(c);
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
