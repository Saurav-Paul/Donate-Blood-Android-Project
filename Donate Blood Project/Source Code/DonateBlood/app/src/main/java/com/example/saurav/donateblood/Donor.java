package com.example.saurav.donateblood;

public class Donor {

    String userName ,useremail, userpass,userBloodGroup,userAge,userFb,userNumber,userLastTimeDonation ,userTotalDonate ,userInterest,userId;

    public Donor() {

    }



    public Donor(String userName, String useremail, String userpass, String userBloodGroup, String userAge, String userFb, String userNumber, String userLastTimeDonation, String userTotalDonate, String userInterest, String userId) {
        this.userName = userName;
        this.useremail = useremail;
        this.userpass = userpass;
        this.userBloodGroup = userBloodGroup;
        this.userAge = userAge;
        this.userFb = userFb;
        this.userNumber = userNumber;
        this.userLastTimeDonation = userLastTimeDonation;
        this.userTotalDonate = userTotalDonate;
        this.userInterest = userInterest;
        this.userId =userId;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getUserBloodGroup() {
        return userBloodGroup;
    }

    public void setUserBloodGroup(String userBloodGroup) {
        this.userBloodGroup = userBloodGroup;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserFb() {
        return userFb;
    }

    public void setUserFb(String userFb) {
        this.userFb = userFb;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserLastTimeDonation() {
        return userLastTimeDonation;
    }

    public void setUserLastTimeDonation(String userLastTimeDonation) {
        this.userLastTimeDonation = userLastTimeDonation;
    }

    public String getUserTotalDonate() {
        return userTotalDonate;
    }

    public void setUserTotalDonate(String userTotalDonate) {
        this.userTotalDonate = userTotalDonate;
    }

    public String getUserInterest() {
        return userInterest;
    }

    public void setUserInterest(String userInterest) {
        this.userInterest = userInterest;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
