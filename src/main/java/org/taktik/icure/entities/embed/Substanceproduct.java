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

package org.taktik.icure.entities.embed;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.taktik.icure.entities.base.Code;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Substanceproduct implements Serializable {
	protected List<Code> intendedcds;
	protected List<Code> deliveredcds;
	protected String intendedname;
	protected Object deliveredname;

	public List<Code> getIntendedcds() {
		return intendedcds;
	}

	public void setIntendedcds(List<Code> intendedcds) {
		this.intendedcds = intendedcds;
	}

	public List<Code> getDeliveredcds() {
		return deliveredcds;
	}

	public void setDeliveredcds(List<Code> deliveredcds) {
		this.deliveredcds = deliveredcds;
	}

	public String getIntendedname() {
		return intendedname;
	}

	public void setIntendedname(String intendedname) {
		this.intendedname = intendedname;
	}

	public Object getDeliveredname() {
		return deliveredname;
	}

	public void setDeliveredname(Object deliveredname) {
		this.deliveredname = deliveredname;
	}
}
