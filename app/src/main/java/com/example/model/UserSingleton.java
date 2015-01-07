package com.example.model;



/**
 * Created by admin on 11/24/14.
 */
public class UserSingleton {

    // Limits
    private int MAXACCOUNTNUM;
    private String CREDIT = "credit";
    private String SAVINGS = "savings";
    // Singleton
    private volatile static UserSingleton userInstance = null;


    //User Fields
    private String userType;// We should make this an object
    private String userName;
    private int userID;

    // Accounts
    private int numOfAccounts;
    private int AccountValues[];    // Related by index to Account Values
    private String AccountTypes[];  //  ex. First account==0, Debit.



    // No-Access Dummy Constructor
    private UserSingleton(){};

    public static synchronized UserSingleton getInstance()
    {
        if (userInstance == null)               // Lazy Instantiation
        {userInstance = new UserSingleton();}

        return userInstance;
    }

    // Getter Methods
    public String getuserType()
    {return userType;}
    public String getuserName()
        {return userName;}
    public int getnumOfAccounts()
        {return numOfAccounts;}
    public int getuserID()
    {return userID;}
    public int[] getAccountValues()
    {return AccountValues;}
    public String[] getAccountTypes()
    {return AccountTypes;}
    public String getSingleAccountType(int index)
    {return AccountTypes[index];}
    public int getSingleAccountValue(int index)
    {return AccountValues[index];}



    // Setter Methods
    public void setuserType(int type) //
    {
        if (type == 0)
            userType = "Customer";
        if (type == 1)
            userType = "Teller";
        else
            userType = "Customer";
    }

    public void setuserName(String newuserName)
    {userName = newuserName;}
    public void setuserID(int newuserID)
        {userID = newuserID;}
    public void setnumOfAccounts(int newnumOfAccounts)
    {numOfAccounts = newnumOfAccounts;}
    public void setAccountValues(int[] newAccountValues)
    {AccountValues = newAccountValues;}
    public void setAccountTypes(String[] newAccountTypes)
    {AccountTypes = newAccountTypes;}




    public void setBobInfo()
    {
        MAXACCOUNTNUM = 3;
        userInstance = getInstance();
        userType = "Customer";
        userName = "Bob";
        userID = 1;
        numOfAccounts = 3;
        AccountValues = new int[]{1,2,3};    // Related by index to Account Values
        AccountTypes = new String[]{CREDIT,SAVINGS,CREDIT};  //  ex. First account==0, Debit.

    }

    public void clearCurrent()
    {
        userInstance = null;

    }





}
