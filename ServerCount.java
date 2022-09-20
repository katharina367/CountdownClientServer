
public class ServerCount implements ServerState {

	Integer i;
	
	public ServerCount(Integer i) {
		this.i = i;
	}
	
	@Override
	public ServerState execute(CountdownServerA connection) {
		if (i > 1) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return new ServerError("Sleeping problems");
			}
			connection.send(ServerProtocol.getNumber(--i));
			return new ServerCount(i);
		} if (i == 1) connection.send((--i).toString());
		else connection.send(i.toString());
		return new ServerBye();
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
