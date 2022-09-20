
public class ClientEnd implements ClientState {

	@Override
	public ClientState execute(CountdownClientA connection) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEndingState() {
		return true;
	}

	@Override
	public boolean isErrorState() {
		return false;
	}

}
