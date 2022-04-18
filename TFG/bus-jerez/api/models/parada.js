const mongoose = require('mongoose')

const paradaSchema = new mongoose.Schema({
    nombre: {
        type: String,
        required: true,
        trim: true
    },
    descripcion:{
        type: String,
        required: true,
        trim: true 
    },
    coordenadas:{
        type: String,
        required: true,
        trim: true 
    }
})

const Parada = mongoose.model('Parada', paradaSchema)

module.exports = Parada