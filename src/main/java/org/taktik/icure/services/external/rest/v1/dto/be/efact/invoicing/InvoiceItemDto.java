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

package org.taktik.icure.services.external.rest.v1.dto.be.efact.invoicing;

import java.util.Date;

import org.taktik.icure.be.ehealth.logic.efact.impl.invoicing.EIDItem;
import org.taktik.icure.be.ehealth.logic.efact.impl.invoicing.InvoicingPrescriberCode;
import org.taktik.icure.be.ehealth.logic.efact.impl.invoicing.InvoicingSideCode;
import org.taktik.icure.be.ehealth.logic.efact.impl.invoicing.InvoicingTimeOfDay;

/**
 * Created with IntelliJ IDEA.
 * User: aduchate
 * Date: 19/08/15
 * Time: 11:12
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("unused")
public class InvoiceItemDto {
    private Date dateCode;
    private long codeNomenclature;
	private Long relatedCode;

    private EIDItemDto eidItem;
    private String insuranceRef;
    private Date insuranceRefDate;

    private int units;

    private long reimbursedAmount;
    private long patientFee;
    private long doctorSupplement;

    private InvoicingSideCode sideCode;
    private InvoicingTimeOfDay timeOfDay;

    private Integer override3rdPayerCode;
    private String gnotionNihii;

    private InvoicingPrescriberCode prescriberNorm;
    private String prescriberNihii;

    private Integer personalInterventionCoveredByThirdPartyCode;

    private String doctorIdentificationNumber;
    private String invoiceRef;

    public InvoiceItemDto() {
    }

    public Date getDateCode() {
        return dateCode;
    }

    public void setDateCode(Date dateCode) {
        this.dateCode = dateCode;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public long getCodeNomenclature() {
        return codeNomenclature;
    }

    public void setCodeNomenclature(long codeNomenclature) {
        this.codeNomenclature = codeNomenclature;
    }

	public Long getRelatedCode() {
		return relatedCode;
	}

	public void setRelatedCode(Long relatedCode) {
		this.relatedCode = relatedCode;
	}

	public long getReimbursedAmount() {
        return reimbursedAmount;
    }

    public void setReimbursedAmount(long reimbursedAmount) {
        this.reimbursedAmount = reimbursedAmount;
    }

    public long getPatientFee() {
        return patientFee;
    }

    public void setPatientFee(long patientFee) {
        this.patientFee = patientFee;
    }

    public long getDoctorSupplement() {
        return doctorSupplement;
    }

    public void setDoctorSupplement(long doctorSupplement) {
        this.doctorSupplement = doctorSupplement;
    }

    public EIDItemDto getEidItem() {
        return eidItem;
    }

    public void setEidItem(EIDItemDto eidItem) {
        this.eidItem = eidItem;
    }

    public Integer getOverride3rdPayerCode() {
        return override3rdPayerCode;
    }

    public void setOverride3rdPayerCode(Integer override3rdPayerCode) {
        this.override3rdPayerCode = override3rdPayerCode;
    }

    public Integer getPersonalInterventionCoveredByThirdPartyCode() {
        return personalInterventionCoveredByThirdPartyCode;
    }

    public void setPersonalInterventionCoveredByThirdPartyCode(Integer personalInterventionCoveredByThirdPartyCode) {
        this.personalInterventionCoveredByThirdPartyCode = personalInterventionCoveredByThirdPartyCode;
    }

    public String getInsuranceRef() {
        return insuranceRef;
    }

    public void setInsuranceRef(String insuranceRef) {
        this.insuranceRef = insuranceRef;
    }

    public Date getInsuranceRefDate() {
        return insuranceRefDate;
    }

    public void setInsuranceRefDate(Date insuranceRefDate) {
        this.insuranceRefDate = insuranceRefDate;
    }

    public String getGnotionNihii() {
        return gnotionNihii;
    }

    public void setGnotionNihii(String gnotionNihii) {
        this.gnotionNihii = gnotionNihii;
    }

    public InvoicingPrescriberCode getPrescriberNorm() {
        return prescriberNorm;
    }

    public void setPrescriberNorm(InvoicingPrescriberCode prescriberNorm) {
        this.prescriberNorm = prescriberNorm;
    }

    public InvoicingSideCode getSideCode() {
        return sideCode;
    }

    public void setSideCode(InvoicingSideCode sideCode) {
        this.sideCode = sideCode;
    }

    public InvoicingTimeOfDay getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(InvoicingTimeOfDay timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public String getPrescriberNihii() {
        return prescriberNihii;
    }

    public void setPrescriberNihii(String prescriberNihii) {
        this.prescriberNihii = prescriberNihii;
    }

    public String getDoctorIdentificationNumber() {
        return doctorIdentificationNumber;
    }

    public void setDoctorIdentificationNumber(String doctorIdentificationNumber) {
        this.doctorIdentificationNumber = doctorIdentificationNumber;
    }

    public String getInvoiceRef() {
        return invoiceRef;
    }

    public void setInvoiceRef(String invoiceRef) {
        this.invoiceRef = invoiceRef;
    }
}
