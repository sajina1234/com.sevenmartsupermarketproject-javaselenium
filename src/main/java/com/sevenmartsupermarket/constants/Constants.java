package com.sevenmartsupermarket.constants;

public class Constants {
	public static final String CONFIG_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
public static final String EXCEL_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\ExcelFiles\\";
public static final String IMAGE_DIRECTORY=System.getProperty("user.dir")+"\\src\\main\\resources\\Images\\";
public static final String EXTENT_REPORT_FILEPATH=System.getProperty("user.dir")+"\\ExtentReports";
/*Expected data*/
/*LoginPage*/
public static final String EXPECTED_PROFILE_NAME = "Admin";
public static final String EXPECTED_LOGO_TEXT = "7rmart supermarket";
public static final String EXPECTED_ERROR_MESSAGE = "Alert!";
public static final String EXPECTED_INVALIDLOGIN_ERROR_MESSAGE = "Alert!";
/*AdminUsersPage*/
public static final String EXPECTED_ALERT_MESSAGE="Alert!";
public static final String EXPECTED_SEARCH_RESULT="pf";
/*ManageUsersPage*/
public static final String EXPECTED_STATUS="Active";
public static final String EXPECTED_USER_SEARCH_RESULT=".........RESULT NOT FOUND.......";
/*ManageDeliveryBoyPage*/
public static final String EXPECTED_DELIVERYBOY_SEARCH_RESULT="Sajin";
}
