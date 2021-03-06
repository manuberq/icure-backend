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

package org.taktik.icure.dao.impl.keymanagers;


import org.springframework.beans.factory.annotation.Qualifier;
import org.taktik.icure.dao.impl.idgenerators.IDGenerator;
import org.taktik.icure.entities.base.Identifiable;

import javax.inject.Inject;

public class IdentifiableKeyManager<T extends Identifiable<Integer>> implements KeyManager<T, Integer> {
	private final IDGenerator idGenerator;

    public IdentifiableKeyManager(IDGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}

	@Override
	public void setNewKey(T entity, String sequenceName) {
		if (entity.getId() == null) {
			entity.setId(idGenerator.incrementAndGet(sequenceName));
		}
	}

	@Override
	public Integer getKey(T entity) {
		return entity.getId();
	}
}