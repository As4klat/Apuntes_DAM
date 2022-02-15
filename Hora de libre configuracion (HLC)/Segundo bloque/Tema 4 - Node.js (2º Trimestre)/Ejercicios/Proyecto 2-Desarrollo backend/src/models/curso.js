const mongoose = require('mongoose')

const cursoSchema = new mongoose.Schema({
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
        type: mongoose.Schema.Types.ObjectId,
        required: true,
        ref: 'User'
    }
})

cursoSchema.virtual('user', {
    ref: 'User',
    localField: '_id',
    foreignField: 'curso'
})

const Curso = mongoose.model('Curso', cursoSchema)

module.exports = Curso