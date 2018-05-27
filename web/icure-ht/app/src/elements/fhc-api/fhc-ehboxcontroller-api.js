const $_documentContainer = document.createElement('template');
$_documentContainer.setAttribute('style', 'display: none;');

$_documentContainer.innerHTML = `<dom-module id="fhc-ehboxcontroller-api">
    <template>
        <style>
        </style>

        <iron-ajax id="deleteMessagesUsingPOST" method="POST" headers="[[headers]]" url="/ehbox/move/from/{source}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="getFullMessageUsingGET" method="GET" headers="[[headers]]" url="/ehbox/{boxId}/{messageId}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="getInfosUsingGET" method="GET" headers="[[headers]]" url="/ehbox" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="loadMessagesUsingGET" method="GET" headers="[[headers]]" url="/ehbox/{boxId}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="moveMessagesUsingPOST" method="POST" headers="[[headers]]" url="/ehbox/move/from/{source}/to/{destination}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="sendMessageUsingPOST" method="POST" headers="[[headers]]" url="/ehbox" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
    </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);
