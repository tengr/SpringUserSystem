package tengr.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * An entity Client composed by three fields (id, name, status, type).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author tengr
 */
@Entity
@Table(name = "clients")
public class Client {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An autogenerated id (unique for each client in the db)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  // The client's name
  @NotNull
  private String name;
  
  // The client's status
  @NotNull
  private String status;

  // The client's name
  @NotNull
  private String type;

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  public Client() { }

  public Client(long id) { 
    this.id = id;
  }
  
  public Client(String name, String status, String type) {
    this.name = name;
    this.status = status;
    this.type = type;
  }

  // Getter and setter methods
  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String value) {
    this.name = value;
  }

  public String getStatus() {
    return status;
  }
  
  public void setStatus(String value) {
    this.status = value;
  }

  public String getType() {
    return type;
  }
  
  public void setType(String value) {
    this.type = value;
  }
  
  
  
} // class Client