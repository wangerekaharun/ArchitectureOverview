package ke.co.appslab.architectureoverview.data.datastates;

import ke.co.appslab.architectureoverview.models.CharactersResponse;

public class CharactersState {
    private CharactersResponse charactersResponse;
    private Throwable throwable;

    public CharactersState(CharactersResponse charactersResponse) {
        this.charactersResponse = charactersResponse;
        this.throwable = null;
    }

    public CharactersState(Throwable throwable) {
        this.throwable = throwable;
        this.charactersResponse = null;
    }

    public CharactersResponse getCharactersResponse() {
        return charactersResponse;
    }

    public void setCharactersResponse(CharactersResponse charactersResponse) {
        this.charactersResponse = charactersResponse;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
