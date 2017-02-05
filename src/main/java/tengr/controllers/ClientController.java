package tengr.controllers;

import tengr.models.Client;
import tengr.models.ClientDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A class to test interactions with the MySQL database using the ClientDao class.
 *
 * @author tengr
 */
@Controller
public class ClientController {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * /create  --> Create a new client and save it in the database.
   * 
   * @param name Client's name
   * @param status Client's status
   * @param type Client's type
   * @return A string describing if the client is succesfully created or not.
   */
  @RequestMapping("/createClient")
  @ResponseBody
  public String create(String name, String status, String type) {
    Client client = null;
    try {
      client = new Client(name, status, type);
      clientDao.save(client);
    }
    catch (Exception ex) {
      return "Error creating the client: " + ex.toString();
    }
    return "Client succesfully created! (id = " + client.getId() + ")";
  }
  
  /**
   * /delete  --> Delete the client having the passed id.
   * 
   * @param id The id of the client to delete
   * @return A string describing if the client is succesfully deleted or not.
   */
  @RequestMapping("/deleteClient")
  @ResponseBody
  public String delete(long id) {
    try {
      Client client = new Client(id);
      clientDao.delete(client);
    }
    catch (Exception ex) {
      return "Error deleting the client: " + ex.toString();
    }
    return "Client succesfully deleted!";
  }
  
  /**
   * /get-client-by-name  --> Return the id for the client having the passed name.
   * 
   * @param name The name to search in the database.
   * @return The client id or a message error if the client is not found.
   */
  @RequestMapping("/get-client-by-name")
  @ResponseBody
  public String getByName(String name) {
    String clientId;
    try {
      Client client = clientDao.findByName(name);
      clientId = String.valueOf(client.getId());
    }
    catch (Exception ex) {
      return "Client not found";
    }
    return "The client id is: " + clientId;
  }
  
  /**
   * /update  --> Update the type and the name for the client in the database 
   * having the passed id.
   * 
   * @param id The id for the client to update.
   * @param name The new name.
   * @param status The new status.
   * @param type The new type.
   * @return A string describing if the client is succesfully updated or not.
   */
  @RequestMapping("/updateClient")
  @ResponseBody
  public String updateClient(long id, String name, String status, String type) {
    try {
      Client client = clientDao.findOne(id);
      client.setName(name);
      client.setStatus(status);
      client.setType(type);
      clientDao.save(client);
    }
    catch (Exception ex) {
      return "Error updating the client: " + ex.toString();
    }
    return "Client succesfully updated!";
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private ClientDao clientDao;
  
} // class ClientController
