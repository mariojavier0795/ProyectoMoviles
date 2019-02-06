/**
 * Enfermedad.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    codigoEnfermedad:'string',
    nombreEnfermedad:'string',
    observacionesEnfermedad:'string',
    historialEnfermedad:{
      collection:'historialenfermedad',
      via:'ownerEnfermedad'
    }
  }

};
