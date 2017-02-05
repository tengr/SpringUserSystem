package tengr.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

/**
 * A DAO for the entity Account is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 * The magic is that such methods must not be implemented, and moreover it is
 * possible create new query methods working only by defining their signature!
 * 
 * @author tengr
 */
@Transactional
public interface AccountDao extends CrudRepository<Account, Long> {

  /**
   * Return the account having the passed name or null if no account is found.
   * 
   * @param name the account name.
   */
  public Account findByStatus(String status);

} // class AccountDao
