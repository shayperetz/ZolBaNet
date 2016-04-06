/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerInstallation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author peretzs
 */
public class getInstallationConfig {
    
    public static String[] getConfig() 
    {
	String Config[] = new String[5];
	Properties prop = new Properties();
	InputStream input = null;
	try {
            input = new FileInputStream("C:\\Users\\eilons\\Documents\\GitHub\\zolbareshet\\zolbareshet\\web\\WEB-INF\\config.properties");
            prop.load(input);
            Config[0] = prop.getProperty("URL");
            Config[1] = prop.getProperty("Coding");
            Config[2] = prop.getProperty("DataBaseName");
            Config[3] = prop.getProperty("DataBaseUserName");
            Config[4] = prop.getProperty("DataBasePassword");
            } 
        catch (IOException ex)
            {
		ex.printStackTrace();
            }
        finally 
            {
		if (input != null) 
                {
                    try {
                        input.close();
                        } 
                    catch (IOException e) 
                        {
                        e.printStackTrace();
                        }
		}
            }
    return Config;
}

    public static String getURL() {
        String URLConfig = "";
        Properties prop = new Properties();
        InputStream input = null;
        try {
                input = new FileInputStream("C:\\ProgramData\\ZolBareshet\\config.properties");
                prop.load(input);
                URLConfig = prop.getProperty("URL");
            } 
        catch (IOException ex) 
        {
                ex.printStackTrace();
        } 
        finally 
        {
                if (input != null)
                {
                    try {
                            input.close();
                        } 
                    catch (IOException e)
                    {
                            e.printStackTrace();
                    }
                }
        }
        return URLConfig;

    }


	public static String getCoding() {
		String CodeConfig = "";
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("C:\\ProgramData\\ZolBareshet\\config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			CodeConfig = prop.getProperty("Coding");


		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return CodeConfig;

	}

	public static String getDataBaseName() {
		String DataBaseNameConfig = "";
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("C:\\Users\\eilons\\Documents\\GitHub\\zolbareshet\\zolbareshet\\web\\WEB-INF\\config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			DataBaseNameConfig = prop.getProperty("DataBaseName");


		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return DataBaseNameConfig;

	}


	public static String getDataBaseUserName() {
		String DataBaseUserNameConfig = "";
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("C:\\ProgramData\\ZolBareshet\\config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			DataBaseUserNameConfig = prop.getProperty("DataBaseUserName");


		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return DataBaseUserNameConfig;

	}

	public static String getDataBasePassword() {
		String DataBasePasswordConfig = "";
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("C:\\ProgramData\\ZolBareshet\\config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			DataBasePasswordConfig = prop.getProperty("DataBasePassword");


		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return DataBasePasswordConfig;

	}

	public static String getDataBaseURL() {
		String DataBaseURL = "";
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("C:\\Users\\eilons\\Documents\\zolbareshet\\GitHub\\zolbareshet\\web\\WEB-INF\\config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			DataBaseURL = prop.getProperty("DataBaseURL");


		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return DataBaseURL;

	}
}
