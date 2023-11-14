package com.university.booking_university_project.configuration;

import com.university.booking_university_project.exception.ConfigurationFileReaderException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;
import org.springframework.context.annotation.Configuration;

/**
 * You need to add file to your resources with name {@link #CONFIG_FILE_NAME}, then add all properties to that file,
 * that defined in this class as <code>private static final String</code> fields.
 * */
@Configuration
public class ConfigReader {
  private static final String CONFIG_FILE_NAME = "secrets.properties";

  private static final String APP_EMAIL_LOGIN_FIELD_NAME = "applicationEmailLogin";
  private static final String APP_EMAIL_PASSWORD_FIELD_NAME = "applicationEmailPassword";

  private Properties properties;

  public ConfigReader() {
    URL configFile = getClass().getClassLoader().getResource(CONFIG_FILE_NAME);
    if (configFile == null)
      throw new ConfigurationFileReaderException(CONFIG_FILE_NAME);

    try {
      Paths.get(configFile.toURI());
    } catch (URISyntaxException e) {
      throw new ConfigurationFileReaderException(CONFIG_FILE_NAME);
    }

    try (InputStream input = configFile.openStream()) {
      if (input == null) {
        throw new ConfigurationFileReaderException(CONFIG_FILE_NAME);
      }
      properties = new Properties();
      properties.load(input);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * For correct {@link BookingUniversityProjectConfiguration#getJavaMailSender()} work, a gmail mail must be configured.
   * This method return login of such email.
   * */
  public String getAppEmailLogin() {
    if (!properties.containsKey(APP_EMAIL_LOGIN_FIELD_NAME))
      throw new ConfigurationFileReaderException(APP_EMAIL_LOGIN_FIELD_NAME, CONFIG_FILE_NAME);

    return properties.getProperty(APP_EMAIL_LOGIN_FIELD_NAME);
  }

  /**
   * For correct {@link BookingUniversityProjectConfiguration#getJavaMailSender()} work, a gmail mail must be configured.
   * This method return password of such email.
   * */
  public String getAppEmailPassword() {
    if (!properties.containsKey(APP_EMAIL_PASSWORD_FIELD_NAME))
      throw new ConfigurationFileReaderException(APP_EMAIL_PASSWORD_FIELD_NAME, CONFIG_FILE_NAME);

    return properties.getProperty(APP_EMAIL_PASSWORD_FIELD_NAME);
  }
}