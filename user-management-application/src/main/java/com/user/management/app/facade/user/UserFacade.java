/**
 * Facade pattern
 * This serves as an interface named UserFacade
 * hides the complexities of the system.
 */
package com.user.management.app.facade.user;

import com.user.management.app.model.user.User;

public interface UserFacade {
    User getUserById(int id);
    boolean updateUser(User user);
}
