const $_documentContainer = document.createElement('template');
$_documentContainer.setAttribute('style', 'display: none;');

$_documentContainer.innerHTML = `<dom-module id="fhc-addressbookcontroller-api">
    <template>
        <style>
        </style>

        <iron-ajax id="getHcpByNihiiUsingGET" method="GET" headers="[[headers]]" url="/ab/hcp/nihii/{nihii}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="getHcpBySsinUsingGET" method="GET" headers="[[headers]]" url="/ab/hcp/ssin/{ssin}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="getOrgByCbeUsingGET" method="GET" headers="[[headers]]" url="/ab/org/cbe/{cbe}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="getOrgByEhpUsingGET" method="GET" headers="[[headers]]" url="/ab/org/ehp/{ehp}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="getOrgByNihiiUsingGET" method="GET" headers="[[headers]]" url="/ab/org/nihii/{nihii}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="searchHcpUsingGET" method="GET" headers="[[headers]]" url="/ab/search/hcp/{lastName}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="searchOrgUsingGET" method="GET" headers="[[headers]]" url="/ab/search/org/{name}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
    </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);
