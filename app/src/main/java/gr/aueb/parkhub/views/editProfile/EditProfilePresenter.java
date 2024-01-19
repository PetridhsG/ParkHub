package gr.aueb.parkhub.views.editProfile;

import static gr.aueb.parkhub.views.editProfile.EditProfileActivity.isValidEmail;

import gr.aueb.parkhub.dao.AccountDAO;
import gr.aueb.parkhub.domain.User;

/**
 * @author Χριστουλακης Ιωσηφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class EditProfilePresenter {

    private  AccountDAO accounts;
    private EditProfileView view;
    private User attachedUser;

    /**
     * Αρχικοποιεί τον presenter
     * έτσι ώστε ο χρήστης να αλλάξει τα στοιχεία του
     * @param view Ένα instance του view
     * @param accountDAO Ένα instance του AccountDAO
     */
    public EditProfilePresenter(EditProfileView view, AccountDAO accountDAO){
        this.view = view;
        this.accounts= accountDAO;
        Integer attachedUserID = view.getAttachedUserID();
        if (attachedUserID == null) {
            attachedUser = null;
        } else {
            attachedUser = accountDAO.find(attachedUserID);
        }

        if (attachedUser !=null){
            view.setContent(attachedUser);
        }

    }

    /**
     * Επιστρέφει στην αρχική οθόνη
     */
    public void onBack(){
        view.homePage(attachedUser.getId());
    }

    /**
     * Αφού ελέγξει την εγκυρότητα των τιμών,
     * μεταβάλλει τα στοιχεία του χρήστη
     * και τέλος επιστρέφει στην αρχική οθόνη
     */
    public void onFinish(){
        String name = view.getName();
        String surname= view.getSurname();
        String email = view.getEmail();
        String password = view.getPassword();
        String phonenumber = view.getTelephone();
        String brand = view.getBrand();
        String model = view.getModel();
        String color = view.getColor();
        String licenseplate = view.getLicensePlate();
        String size = view.getSize();

        if(!name.matches("^[^\\d]*$") || name.length() == 0 ){
            view.showErrorMessage("Please use only letters in the name text.");
        }
        else if(!surname.matches("^[^\\d]*$") || surname.length() == 0 ){
            view.showErrorMessage("Please use only letters in the surname text.");
        }
        else if(!(isValidEmail(email)) || email.length() == 0 ){
            view.showErrorMessage("Please enter a valid email.");
        }
        else if(password.length() == 0 ){
            view.showErrorMessage("Please fill the password text.");
        }
        else if(!phonenumber.matches("^[^a-zA-Z]*$") || phonenumber.length() != 10 ){
            view.showErrorMessage("Please use 10 numbers in the phone number text.");
        }
        else if(!brand.matches("^[^\\d]*$") || brand.length() == 0 ){
            view.showErrorMessage("Please use only letters in the brand text.");
        }
        else if(!model.matches("[a-zA-Z0-9]+") || model.length() == 0 ){
            view.showErrorMessage("Please use only letters and numbers in the model text.");
        }
        else if(!color.matches("^[^\\d]*$") || color.length() == 0 ){
            view.showErrorMessage("Please use only letters in the color text.");
        }
        else if(!licenseplate.matches("[a-zA-Z0-9]+") || licenseplate.length() == 0 ){
            view.showErrorMessage("Please use only letters and numbers in the license plate text.");
        }
        else if(!size.matches("^[^a-zA-Z]*$") || size.length() == 0 ){
            view.showErrorMessage("Please use only numbers in the size text.");
        }
        else{
            this.attachedUser.setName(name);
            this.attachedUser.setSurname(surname);
            this.attachedUser.setEmail(email);
            this.attachedUser.setPassword(password);
            this.attachedUser.setTelephone(phonenumber);
            this.attachedUser.getVehicle().setBrand(brand);
            this.attachedUser.getVehicle().setModel(model);
            this.attachedUser.getVehicle().setSize(Double.parseDouble(size));
            this.attachedUser.getVehicle().setLicensePlate(licenseplate);
            this.attachedUser.getVehicle().setColor(color);

            view.finish(attachedUser.getId());
        }

    }

}
