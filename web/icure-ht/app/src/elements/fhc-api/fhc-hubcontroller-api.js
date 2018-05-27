const $_documentContainer = document.createElement('template');
$_documentContainer.setAttribute('style', 'display: none;');

$_documentContainer.innerHTML = `<dom-module id="fhc-hubcontroller-api">
    <template>
        <style>
        </style>

        <iron-ajax id="getTransactionUsingGET" method="GET" headers="[[headers]]" url="/hub/{ssin}/{sv}/{sl}/{value}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="getTransactionsListUsingGET" method="GET" headers="[[headers]]" url="/hub/list/{ssin}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="putTransactionUsingPOST" method="POST" headers="[[headers]]" url="/hub/{hubId}/{ssin}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
    </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);
