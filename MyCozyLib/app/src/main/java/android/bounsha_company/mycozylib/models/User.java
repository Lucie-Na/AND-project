package android.bounsha_company.mycozylib.models;

import com.google.firebase.firestore.Exclude;

import java.io.Serializable;

/**
 * The type User.
 */
public class User implements Serializable
{
    private String uid;
    private String pseudo;
    private String email;
    @Exclude
    private boolean isAuthenticated;
    @Exclude
    private boolean isNew;
    @Exclude
    private boolean isCreated;

    /**
     * Instantiates a new User.
     *
     * @param uid    the uid
     * @param pseudo the pseudo
     * @param email  the email
     */
    public User(String uid, String pseudo, String email)
    {
        this.uid=uid;
        this.pseudo = pseudo;
        this.email = email;
    }

    /**
     * Gets uid.
     *
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets uid.
     *
     * @param uid the uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * Gets pseudo.
     *
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Sets pseudo.
     *
     * @param pseudo the pseudo
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Is authenticated boolean.
     *
     * @return the boolean
     */
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    /**
     * Sets authenticated.
     *
     * @param isAuthenticated the is authenticated
     */
    public void setAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    /**
     * Is new boolean.
     *
     * @return the boolean
     */
    public boolean isNew() {
        return isNew;
    }

    /**
     * Sets new.
     *
     * @param isNew the is new
     */
    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    /**
     * Is created boolean.
     *
     * @return the boolean
     */
    public boolean isCreated() {
        return isCreated;
    }

    /**
     * Sets created.
     *
     * @param isCreated the is created
     */
    public void setCreated(boolean isCreated) {
        this.isCreated = isCreated;
    }
}
