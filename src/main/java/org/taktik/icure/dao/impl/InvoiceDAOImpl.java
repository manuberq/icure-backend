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

package org.taktik.icure.dao.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.ektorp.ComplexKey;
import org.ektorp.ViewQuery;
import org.ektorp.support.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.taktik.icure.dao.InvoiceDAO;
import org.taktik.icure.dao.impl.ektorp.CouchDbICureConnector;
import org.taktik.icure.dao.impl.idgenerators.IDGenerator;
import org.taktik.icure.db.PaginatedList;
import org.taktik.icure.db.PaginationOffset;
import org.taktik.icure.entities.Document;
import org.taktik.icure.entities.Invoice;

@Repository("invoiceDAO")
@View(name = "all", map = "function(doc) { if (doc.java_type == 'org.taktik.icure.entities.Invoice' && !doc.deleted) emit( null, doc._id )}")
public class InvoiceDAOImpl extends GenericIcureDAOImpl<Invoice> implements InvoiceDAO {

	@Autowired
	public InvoiceDAOImpl(@SuppressWarnings("SpringJavaAutowiringInspection") @Qualifier("couchdbHealthdata") CouchDbICureConnector db, IDGenerator idGenerator) {
		super(Invoice.class, db, idGenerator);
		initStandardDesignDocument();
	}

	@Override
	@View(name = "by_hcparty_date", map = "classpath:js/invoice/By_hcparty_date_map.js")
	public PaginatedList<Invoice> findByHcParty(String hcParty, Long fromDate, Long toDate, PaginationOffset<ComplexKey> paginationOffset) {
		ComplexKey startKey = paginationOffset.getStartKey() == null ? ComplexKey.of(hcParty, fromDate) : paginationOffset.getStartKey();
		ComplexKey endKey = ComplexKey.of(hcParty, toDate == null ? ComplexKey.emptyObject(): toDate);
		return pagedQueryView("by_hcparty_date", startKey, endKey, paginationOffset, true);
	}

	@Override
	@View(name = "by_hcparty_contact", map = "classpath:js/invoice/By_hcparty_contact_map.js")
	public List<Invoice> listByHcPartyContacts(String hcParty, Set<String> contactId) {
		Set<String> invoiceIds = new HashSet<>(db.queryView(createQuery("by_hcparty_contact").includeDocs(false).keys(contactId.stream().map((c) -> ComplexKey.of(hcParty, c)).collect(Collectors.toList())), String.class));
		return getList(new TreeSet<>(invoiceIds));
	}

	@Override
	@View(name = "by_hcparty_reference", map = "classpath:js/invoice/By_hcparty_reference_map.js")
	public List<Invoice> listByHcPartyReferences(String hcParty, Set<String> invoiceReferences) {
		ViewQuery viewQuery = createQuery("by_hcparty_reference").includeDocs(true);
		if (invoiceReferences != null) {
			viewQuery.keys(invoiceReferences.stream().map((c) -> ComplexKey.of(hcParty, c)).collect(Collectors.toList()));
		}

		return db.queryView(viewQuery, Invoice.class);
	}

	@Override
	@View(name = "by_hcparty_reference", map = "classpath:js/invoice/By_hcparty_reference_map.js")
	public List<Invoice> listByHcPartyReferences(String hcParty, String from, String to, boolean descending, int limit) {

		ComplexKey startKey = ComplexKey.of(hcParty, (descending && from == null) ? ComplexKey.emptyObject() : from);
		ComplexKey endKey = ComplexKey.of(hcParty, (!descending && to == null) ? ComplexKey.emptyObject() : to);

		return db.queryView(createQuery("by_hcparty_reference").includeDocs(true).startKey(startKey).endKey(endKey).descending(descending).limit(limit), Invoice.class);
	}

	@Override
	@View(name = "by_hcparty_recipient", map = "classpath:js/invoice/By_hcparty_recipient_map.js")
	public List<Invoice> listByHcPartyRecipientIds(String hcParty, Set<String> recipientIds) {
		return queryResults(createQuery("by_hcparty_recipient").includeDocs(true).keys(recipientIds.stream().map(id->ComplexKey.of(hcParty,id)).collect(Collectors.toList())));
	}

	@Override
	@View(name = "by_hcparty_patientfk", map = "classpath:js/invoice/By_hcparty_patientfk_map.js")
	public List<Invoice> listByHcPartyPatientFk(String hcParty, Set<String> secretPatientKeys) {
		ComplexKey[] keys = secretPatientKeys.stream().map(fk -> ComplexKey.of(hcParty, fk)).collect(Collectors.toList()).toArray(new ComplexKey[secretPatientKeys.size()]);

		return queryResults(createQuery("by_hcparty_patientfk").includeDocs(true).keys(Arrays.asList(keys)));
	}

	@Override
	@View(name = "by_hcparty_recipient_unsent", map = "classpath:js/invoice/By_hcparty_recipient_unsent_map.js")
	public List<Invoice> listByHcPartyRecipientIdsUnsent(String hcParty, Set<String> recipientIds) {
		List<Invoice> res = queryResults(createQuery("by_hcparty_recipient_unsent").includeDocs(true).keys(recipientIds.stream().map(id -> ComplexKey.of(hcParty, id)).collect(Collectors.toList())));
		return res;
	}

	@Override
	@View(name = "by_hcparty_patientfk_unsent", map = "classpath:js/invoice/By_hcparty_patientfk_unsent_map.js")
	public List<Invoice> listByHcPartyPatientFkUnsent(String hcParty, Set<String> secretPatientKeys) {
		ComplexKey[] keys = secretPatientKeys.stream().map(fk -> ComplexKey.of(hcParty, fk)).collect(Collectors.toList()).toArray(new ComplexKey[secretPatientKeys.size()]);

		return queryResults(createQuery("by_hcparty_patientfk_unsent").includeDocs(true).keys(Arrays.asList(keys)));
	}

	@Override
	@View(name = "by_serviceid", map = "classpath:js/invoice/By_serviceid_map.js")
	public List<Invoice> listByServiceIds(Set<String> serviceIds) {
		return queryResults(createQuery("by_serviceid").includeDocs(true).keys(serviceIds));
	}

	@Override
	@View(name = "by_status_hcps_sentdate", map = "classpath:js/invoice/By_status_hcps_sentdate_map.js")
	public List<Invoice> listAllHcpsByStatus(String status, Long from, Long to, List<String> hcpIds) {
		Set<String> ids = new HashSet<>();
		for (String hcpId : hcpIds) {
			ids.addAll(db.queryView(createQuery("by_status_hcps_sentdate").includeDocs(false)
					.startKey(ComplexKey.of(status,hcpId,from))
					.endKey(ComplexKey.of(status,hcpId,to!=null?to:ComplexKey.emptyObject())),String.class));
		}
		return getList(ids);
	}

	@Override
	@View(name = "conflicts", map = "function(doc) { if (doc.java_type == 'org.taktik.icure.entities.Invoice' && !doc.deleted && doc._conflicts) emit(doc._id )}")
	public List<Invoice> listConflicts() {
		return queryView("conflicts");
	}

}
