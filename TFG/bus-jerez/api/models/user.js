const mongoose = require('mongoose')

const lineaSchema = new mongoose.Schema({
    nombre: {
        type: String,
        required: true,
        trim: true
    },
})

const Linea = mongoose.model('Linea', lineaSchema)

module.exports = Linea