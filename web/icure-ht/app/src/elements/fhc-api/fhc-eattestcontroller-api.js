const $_documentContainer = document.createElement('template');
$_documentContainer.setAttribute('style', 'display: none;');

$_documentContainer.innerHTML = `<dom-module id="fhc-eattestcontroller-api">
    <template>
        <style>
        </style>

        <iron-ajax id="sendAttestUsingPOST" method="POST" headers="[[headers]]" url="/eattest/send/{patientSsin}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="sendAttestWithResponseUsingPOST" method="POST" headers="[[headers]]" url="/eattest/send/{patientSsin}/verbose" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
    </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);
