package Models;

import javafx.beans.property.SimpleStringProperty;

public class Website {

  private final SimpleStringProperty websiteName = new SimpleStringProperty("");
  private final SimpleStringProperty username = new SimpleStringProperty("");
  private final SimpleStringProperty password = new SimpleStringProperty("");

  public Website() {
    this("", "", "");
  }

  public Website(String websiteName, String username, String password) {
    setWebsiteName(websiteName);
    setUsername(username);
    setPassword(password);
  }

  public String getWebsiteName() {
    return websiteName.get();
  }

  public SimpleStringProperty websiteNameProperty() {
    return websiteName;
  }

  public void setWebsiteName(String websiteName) {
    this.websiteName.set(websiteName);
  }

  public String getUsername() {
    return username.get();
  }

  public SimpleStringProperty usernameProperty() {
    return username;
  }

  public void setUsername(String username) {
    this.username.set(username);
  }

  public String getPassword() {
    return password.get();
  }

  public SimpleStringProperty passwordProperty() {
    return password;
  }

  public void setPassword(String password) {
    this.password.set(password);
  }
}
