const $_documentContainer = document.createElement('template');
$_documentContainer.setAttribute('style', 'display: none;');

$_documentContainer.innerHTML = `<dom-module id="fhc-basicerrorcontroller-api">
    <template>
        <style>
        </style>

        <iron-ajax id="errorHtmlUsingDELETE" method="DELETE" headers="[[headers]]" url="/error" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="errorHtmlUsingGET" method="GET" headers="[[headers]]" url="/error" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="errorHtmlUsingHEAD" method="HEAD" headers="[[headers]]" url="/error" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="errorHtmlUsingOPTIONS" method="OPTIONS" headers="[[headers]]" url="/error" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="errorHtmlUsingPATCH" method="PATCH" headers="[[headers]]" url="/error" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="errorHtmlUsingPOST" method="POST" headers="[[headers]]" url="/error" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="errorHtmlUsingPUT" method="PUT" headers="[[headers]]" url="/error" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
    </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);
