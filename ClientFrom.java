
public class ClientFrom implements ClientState{

	int i;
	
	public ClientFrom(int i) {
		this.i = i;
	}
	
	@Override
	public ClientState execute(CountdownClientA connection) {
		int count = this.i;
		connection.send(ClientProtocol.getFrom(count));
		return new ClientStart(count);
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
