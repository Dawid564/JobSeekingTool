package org.webwork.find.repositor;

import org.webwork.find.domain.User;

public interface JdbcCorporate {
	String updateName(User user);
	String addNewUser(User user);
}
