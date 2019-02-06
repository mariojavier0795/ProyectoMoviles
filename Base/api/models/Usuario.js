/**
 * Usuario.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    cedula:'string',
    nombre:'string',
    apellido:'string',
    direccion:'string',
    password:"string",
    edad:'string',
    empleado:{
      collection:'empleado',
      via:'owner'
    },
    doctor:{
      collection:'doctor',
      via:'owner'
    },
    historial:{
      collection:'historial',
      via:'owner'
    }
  }

};

