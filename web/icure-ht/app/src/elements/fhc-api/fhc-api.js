import './fhc-addressbookcontroller-api.js';
import './fhc-basicerrorcontroller-api.js';
import './fhc-eattestcontroller-api.js';
import './fhc-ehboxcontroller-api.js';
import './fhc-geninscontroller-api.js';
import './fhc-hubcontroller-api.js';
import './fhc-recipecontroller-api.js';
import './fhc-stscontroller-api.js';
class FhcApi extends Polymer.mixinBehaviors([], Polymer.Element) {
  static get template() {
    return Polymer.html`
        <style>
        </style>

        <fhc-addressbookcontroller-api id="fhc-addressbookcontroller-api" host="[[host]]" headers="[[headers]]"></fhc-addressbookcontroller-api>
        <fhc-basicerrorcontroller-api id="fhc-basicerrorcontroller-api" host="[[host]]" headers="[[headers]]"></fhc-basicerrorcontroller-api>
        <fhc-eattestcontroller-api id="fhc-eattestcontroller-api" host="[[host]]" headers="[[headers]]"></fhc-eattestcontroller-api>
        <fhc-ehboxcontroller-api id="fhc-ehboxcontroller-api" host="[[host]]" headers="[[headers]]"></fhc-ehboxcontroller-api>
        <fhc-geninscontroller-api id="fhc-geninscontroller-api" host="[[host]]" headers="[[headers]]"></fhc-geninscontroller-api>
        <fhc-hubcontroller-api id="fhc-hubcontroller-api" host="[[host]]" headers="[[headers]]"></fhc-hubcontroller-api>
        <fhc-recipecontroller-api id="fhc-recipecontroller-api" host="[[host]]" headers="[[headers]]"></fhc-recipecontroller-api>
        <fhc-stscontroller-api id="fhc-stscontroller-api" host="[[host]]" headers="[[headers]]"></fhc-stscontroller-api>
`;
  }

  static get is() {
    return "fhc-api"
  }

  static get properties() {
    return {
      headers: {
        type: Object,
        value: {"Content-Type": "application/json"}
      },
      host: {
        type: String
      }
    }
  }

  constructor() {
    super()
  }

  Addressbookcontroller() {
    return this.$['fhc-addressbookcontroller-api']
  }

  Basicerrorcontroller() {
    return this.$['fhc-basicerrorcontroller-api']
  }

  Eattestcontroller() {
    return this.$['fhc-eattestcontroller-api']
  }

  Ehboxcontroller() {
    return this.$['fhc-ehboxcontroller-api']
  }

  Geninscontroller() {
    return this.$['fhc-geninscontroller-api']
  }

  Hubcontroller() {
    return this.$['fhc-hubcontroller-api']
  }

  Recipecontroller() {
    return this.$['fhc-recipecontroller-api']
  }

  Stscontroller() {
    return this.$['fhc-stscontroller-api']
  }
}

customElements.define(FhcApi.is, FhcApi)
