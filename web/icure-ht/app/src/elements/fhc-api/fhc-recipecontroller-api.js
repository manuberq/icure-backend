const $_documentContainer = document.createElement('template');
$_documentContainer.setAttribute('style', 'display: none;');

$_documentContainer.innerHTML = `<dom-module id="fhc-recipecontroller-api">
    <template>
        <style>
        </style>

        <iron-ajax id="createPrescriptionUsingPOST" method="POST" headers="[[headers]]" url="/recipe" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="getGalToAdministrationUnitUsingGET" method="GET" headers="[[headers]]" url="/recipe/gal/{galId}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="getPrescriptionUsingGET" method="GET" headers="[[headers]]" url="/recipe/{rid}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="listFeedbacksUsingGET" method="GET" headers="[[headers]]" url="/recipe/all/feedbacks" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="listOpenPrescriptionsUsingGET" method="GET" headers="[[headers]]" url="/recipe" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="revokePrescriptionUsingDELETE" method="DELETE" headers="[[headers]]" url="/recipe/{rid}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="sendNotificationUsingPOST" method="POST" headers="[[headers]]" url="/recipe/notify/{rid}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="updateFeedbackFlagUsingPUT" method="PUT" headers="[[headers]]" url="/recipe/{rid}/feedback/{feedbackFlag}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
    </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);
