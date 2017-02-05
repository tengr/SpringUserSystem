package tengr.controllers;

import tengr.models.Account;
import tengr.models.AccountDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A class to test interactions with the MySQL database using the AccountDao class.
 *
 * @author tengr
 */
@Controller
public class AccountController {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * /create  --> Create a new account and save it in the database.
   * 
   * @param login Account's login
   * @param password Account's password
   * @param status Account's status
   * @return A string describing if the account is succesfully created or not.
   */
  @RequestMapping("/createAccount")
  @ResponseBody
  public String create(String login, String password, String status) {
    Account account = null;
    try {
      account = new Account(login, password, status);
      accountDao.save(account);
    }
    catch (Exception ex) {
      return "Error creating the account: " + ex.toString();
    }
    return "Account succesfully created! (id = " + account.getId() + ")";
  }
  
  /**
   * /delete  --> Delete the account having the passed id.
   * 
   * @param id The id of the account to delete
   * @return A string describing if the account is succesfully deleted or not.
   */
  @RequestMapping("/deleteAccount")
  @ResponseBody
  public String delete(long id) {
    try {
      Account account = new Account(id);
      accountDao.delete(account);
    }
    catch (Exception ex) {
      return "Error deleting the account: " + ex.toString();
    }
    return "Account succesfully deleted!";
  }
  
  /**
   * /get-account-by-status  --> Return the id for the account having the passed name.
   * 
   * @param status The status to search in the database.
   * @return The account id or a message error if the account is not found.
   */
  @RequestMapping("/get-account-by-status")
  @ResponseBody
  public String getByName(String status) {
    String accountId;
    try {
      Account account = accountDao.findByStatus(status);
      accountId = String.valueOf(account.getId());
    }
    catch (Exception ex) {
      return "Account not found";
    }
    return "The account id is: " + accountId;
  }
  
  /**
   * /update  --> Update the password for the account in the database 
   * having the passed id.
   * 
   * @param id The id for the account to update.
   * @param password The new password
   * @return A string describing if the account is succesfully updated or not.
   */
  @RequestMapping("/updateAccountPassword")
  @ResponseBody
  public String updateAccountPassword(long id, String newPassword) {
    try {
      Account account = accountDao.findOne(id);
      account.setPassword(newPassword);
      accountDao.save(account);
    }
    catch (Exception ex) {
      return "Error updating the account: " + ex.toString();
    }
    return "Account succesfully updated!";
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private AccountDao accountDao;
  
} // class AccountController
