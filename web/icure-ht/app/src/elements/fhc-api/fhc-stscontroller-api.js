const $_documentContainer = document.createElement('template');
$_documentContainer.setAttribute('style', 'display: none;');

$_documentContainer.innerHTML = `<dom-module id="fhc-stscontroller-api">
    <template>
        <style>
        </style>

        <iron-ajax id="registerTokenUsingPOST" method="POST" headers="[[headers]]" url="/sts/token/{tokenId}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="requestTokenUsingGET" method="GET" headers="[[headers]]" url="/sts/token/{keystoreId}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="uploadKeystoreUsingPOST" method="POST" headers="[[headers]]" url="/sts/keystore" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
    </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);
