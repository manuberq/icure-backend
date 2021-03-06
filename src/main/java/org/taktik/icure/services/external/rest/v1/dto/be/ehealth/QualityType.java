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

package org.taktik.icure.services.external.rest.v1.dto.be.ehealth;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: aduchate
 * Date: 07/12/12
 * Time: 18:13
 * To change this template use File | Settings | File Templates.
 */
public class QualityType implements Serializable {
    String quality;
    IdentifierType identifierType;

    public QualityType() {
    }

    public QualityType(String quality, IdentifierType identfierType) {
        this.quality = quality;
        this.identifierType = identfierType;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public IdentifierType getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(IdentifierType identifierType) {
        this.identifierType = identifierType;
    }

    public static QualityType fromEhType(be.ehealth.businessconnector.ehbox.api.utils.QualityType qt) {
        return new QualityType(qt.getQuality(), IdentifierType.fromEhType(qt.getIdentifierType()));
    }
}
