
public interface ClientState {
	public ClientState execute(CountdownClientA connection);
	public boolean isEndingState();
	public boolean isErrorState();
}
