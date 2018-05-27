const $_documentContainer = document.createElement('template');
$_documentContainer.setAttribute('style', 'display: none;');

$_documentContainer.innerHTML = `<dom-module id="fhc-geninscontroller-api">
    <template>
        <style>
        </style>

        <iron-ajax id="getGeneralInsurabilityByMembershipUsingGET" method="GET" headers="[[headers]]" url="/genins/{io}/{ioMembership}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
        <iron-ajax id="getGeneralInsurabilityUsingGET" method="GET" headers="[[headers]]" url="/genins/{ssin}" handle-as="json" on-error="handleError" with-credentials=""></iron-ajax>
    </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);
