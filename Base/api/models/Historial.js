/**
 * Historial.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    codigoHistorial:'string',
    fecha:'string',
    observaciones:'string',
    historialEnfermedad:{
      collection:'historialenfermedad',
      via:'owner'
    },
    tratamiento:{
      collection:'tratamiento',
      via:'owner'
    },
    owner:{
      model:'usuario'
    }
  }

};

