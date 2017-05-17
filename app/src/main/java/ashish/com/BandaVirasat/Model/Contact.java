package ashish.com.BandaVirasat.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ashish on 17/12/16.
 */

public class Contact implements Parcelable {
    private String contactProfession, contactName, contactAddress, contactNumber;
    private int contactStatus;

    public Contact(){
    }

    public String getContactProfession(){
        return contactProfession;
    }
    public void setContactProfession(String contactProfession){
        this.contactProfession = contactProfession;
    }


    public String getContactName(){
        return contactName;
    }
    public void setContactName(String contactName){
        this.contactName = contactName;
    }


    public String getContactAddress(){
        return contactAddress;
    }
    public void setContactAddress(String contactAddress){
        this.contactAddress = contactAddress;
    }


    public String getContactNumber(){
        return contactNumber;
    }
    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }


    public int getContactStatus(){
        return contactStatus;
    }
    public void setContactStatus(int contactStatus){
        this.contactStatus = contactStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.contactProfession);
        dest.writeString(this.contactName);
        dest.writeString(this.contactAddress);
        dest.writeString(this.contactNumber);
        dest.writeInt(this.contactStatus);
    }

    protected Contact(Parcel in) {
        this.contactProfession = in.readString();
        this.contactName = in.readString();
        this.contactAddress = in.readString();
        this.contactNumber = in.readString();
        this.contactStatus = in.readInt();
    }

    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel source) {
            return new Contact(source);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
