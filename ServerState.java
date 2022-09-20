
public interface ServerState {
	public ServerState execute(CountdownServerA connection);
	public boolean isEndingState();
	public boolean isErrorState();
}
