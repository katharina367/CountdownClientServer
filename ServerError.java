
public class ServerError implements ServerState {

	String msg;
	
	public ServerError(String msg) {
		this.msg = msg;
	}
	
	@Override
	public ServerState execute(CountdownServerA connection) {
		throw new UnsupportedOperationException();
	}
	
	public String getMsg() {
		return msg;
	}

	@Override
	public boolean isEndingState() {
		return false;
	}

	@Override
	public boolean isErrorState() {
		return true;
	}

}
