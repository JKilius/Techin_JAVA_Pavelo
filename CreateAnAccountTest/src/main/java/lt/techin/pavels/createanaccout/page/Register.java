package lt.techin.pavels.createanaccout.page;

public interface Register {

    void enterEmailAddress(String email);
    void enterName(String name);
    void enterPassword(String password);
    void enterConfirmPassword(String confirmPassword);
    void submitRegisterClick();
}
