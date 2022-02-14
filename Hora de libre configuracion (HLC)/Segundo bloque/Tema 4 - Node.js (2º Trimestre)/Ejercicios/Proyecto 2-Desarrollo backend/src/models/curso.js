const mongoose = require('mongoose')

const Curso = mongoose.model('Curso', {
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
    owner:{
        type: mongoose.Schema.ObjectId, ref: 'User',
        required: true
    }
})

module.exports = Curso