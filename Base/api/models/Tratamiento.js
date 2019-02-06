/**
 * Tratamiento.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    codigoTratamiento:'string',
    usoTratamiento:'string',
    observacionTratamiento:'string',
    owner:{
      model:'historial'
    }
  }

};

