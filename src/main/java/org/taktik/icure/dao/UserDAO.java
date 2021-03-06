/*
 * Copyright (C) 2018 Taktik SA
 *
 * This file is part of iCureBackend.
 *
 * iCureBackend is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as published by
 * the Free Software Foundation.
 *
 * iCureBackend is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with iCureBackend.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.taktik.icure.dao;

import org.taktik.icure.db.PaginatedList;
import org.taktik.icure.db.PaginationOffset;
import org.taktik.icure.entities.User;

import java.time.Instant;
import java.util.List;

public interface UserDAO extends GenericDAO<User> {

	List<User> getExpiredUsers(Instant fromExpirationInstant, Instant toExpirationInstant);

    List<User> findByUsername(String searchString);

    List<User> findByEmail(String searchString);

	PaginatedList<User> listUsers(PaginationOffset pagination);

	User getOnFallback(String userId);

	User findOnFallback(String userId);

	User getUserOnUserDb(String userId, String groupId);

	User findUserOnUserDb(String userId, String groupId);

	List<User> getUsersOnDb(String groupId);

	void evictFromCache(String groupId, List<String> userIds);

	User saveOnFallback(User user);
}